package io.swagger.service;

import io.swagger.api.resttemplate.Constants;
import io.swagger.model.PromoCode;
import io.swagger.model.PromoCodePK;
import io.swagger.model.Reservation;
import io.swagger.model.Room;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();

    private final RoomService roomService;

    private final PromoCodeService promoCodeService;

    public ReservationService(RestTemplate restTemplate, RoomService roomService, PromoCodeService promoCodeService) {
        this.restTemplate = restTemplate;
        this.roomService = roomService;
        this.promoCodeService = promoCodeService;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public void deleteReservation(Integer roomId, String guestJMBG,Date dateFrom, Date dateTo) {
        String url = Constants.RESERVATIONS_URL +
                "/rooms/" + roomId +
                "/guests/" + guestJMBG +
                "/dateFrom/" + new SimpleDateFormat("yyyy-MM-dd").format(dateFrom) +
                "/dateTo/" + new SimpleDateFormat("yyyy-MM-dd").format(dateTo);
        restTemplate.delete(url);
    }

    public Reservation getReservation(Integer roomId, String guestJMBG, Date dateFrom, Date dateTo) {
        String url = Constants.RESERVATIONS_URL +
                "/rooms/" + roomId +
                "/guests/" + guestJMBG +
                "/dateFrom/" + new SimpleDateFormat("yyyy-MM-dd").format(dateFrom) +
                "/dateTo/" + new SimpleDateFormat("yyyy-MM-dd").format(dateTo);
        ResponseEntity<Reservation> responseEntity = restTemplate.getForEntity(url,Reservation.class);
        return responseEntity.getBody();
    }

    public List<Reservation> getRoomReservations(Integer roomId) {
        String url = Constants.RESERVATIONS_URL +
                "/rooms/" + roomId;
        ParameterizedTypeReference<List<Reservation>> responseType = new ParameterizedTypeReference<List<Reservation>>() {};

        ResponseEntity<List<Reservation>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        return responseEntity.getBody();
    }

    public List<Reservation> getRoomReservationsOfPeriod(Integer roomId, Reservation reservation){
        String url = Constants.RESERVATIONS_URL +
                "/rooms/" + roomId +
                "/dateFrom/" + new SimpleDateFormat("yyyy-MM-dd").format(reservation.getReservationPK().getDateFrom()) +
                "/dateTo/" + new SimpleDateFormat("yyyy-MM-dd").format(reservation.getReservationPK().getDateTo());
        ParameterizedTypeReference<List<Reservation>> responseType = new ParameterizedTypeReference<List<Reservation>>() {};

        ResponseEntity<List<Reservation>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return responseEntity.getBody();
    }

    public ResponseEntity<String> saveReservation(Integer roomId, String guestJMBG, Reservation reservation) {
        Room room = roomService.getRoom(roomId);
        ResponseEntity<String> responseEntity = checkAvailabilityOfRoom(room,reservation);
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            reservation.setToken(generateToken());
            reservation.setPrice(room.getPrice());

            String url = Constants.RESERVATIONS_URL + "/rooms/" + roomId
                    + "/guests/" + guestJMBG;
            HttpEntity<Reservation> requestEntity = new HttpEntity<>(reservation, headers);
            restTemplate.postForEntity(url, requestEntity, Void.class);

            generatePromoCode(guestJMBG,reservation.getEmail());

            return new ResponseEntity<>("Reservation is successfully made. Your token for access is: " + reservation.getToken(), HttpStatus.OK);
        }
        return responseEntity;
    }

    public ResponseEntity<String> updatePriceOfReservation(Integer roomId, String guestJMBG, Date dateFrom, Date dateTo, PromoCode promoCode) {
        PromoCode promoCodeDb = promoCodeService.getPromoCode(guestJMBG,promoCode.getCode());
        if(!promoCodeDb.isUsed()) {
            Reservation reservation = getReservation(roomId, guestJMBG, dateFrom, dateTo);
            reservation.setPrice(calculatePrice(promoCodeDb.getDiscount(), reservation.getPrice()));

            String url = Constants.RESERVATIONS_URL +
                    "/rooms/" + roomId +
                    "/guests/" + guestJMBG +
                    "/dateFrom/" + new SimpleDateFormat("yyyy-MM-dd").format(reservation.getReservationPK().getDateFrom()) +
                    "/dateTo/" + new SimpleDateFormat("yyyy-MM-dd").format(reservation.getReservationPK().getDateTo());
            HttpEntity<Reservation> requestEntity = new HttpEntity<>(reservation, headers);
            restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Void.class);

            promoCodeService.updatePromoCode(guestJMBG, promoCodeDb);
            return new ResponseEntity<>("PromoCode is used, you got the discount!!!",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("PromoCode is used", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    private ResponseEntity<String> checkAvailabilityOfRoom(Room room, Reservation reservation) {
        Integer roomId = room.getId();
        List<Reservation> roomReservationsOfPeriod = getRoomReservationsOfPeriod(roomId,reservation);
        if(roomReservationsOfPeriod.isEmpty()){
            if(dateValidationForRoomReservation(roomId,reservation)) {
                return new ResponseEntity<>("Room is available for reservation", HttpStatus.OK);
            }
            return new ResponseEntity<>("Date for your reservation is not available", HttpStatus.NOT_ACCEPTABLE);
        }
        else if(roomReservationsOfPeriod.size() < room.getCapacity()){
            int availableSeats = room.getCapacity() - roomReservationsOfPeriod.size();
            return new ResponseEntity<>("Room have " + availableSeats + " more available reservations", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Room is already packed with guests!!!",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    private boolean dateValidationForRoomReservation(Integer roomId, Reservation reservation) {
        List<Reservation> allRoomReservations = getRoomReservations(roomId);
        if(allRoomReservations.isEmpty()){
            return true;
        }
        Date dateFrom = reservation.getReservationPK().getDateFrom();
        return allRoomReservations.stream().anyMatch(roomReservation ->
                dateFrom.after(roomReservation.getReservationPK().getDateTo()));
    }

    private String generateToken() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }

    private void generatePromoCode(String guestJMBG, String email) {
        PromoCode promoCode = new PromoCode();
        PromoCodePK promoCodePK = new PromoCodePK();

        promoCode.setCode("code-"+guestJMBG+"-"+email);
        promoCodePK.setJmbg(guestJMBG);
        promoCode.setPromoCodePK(promoCodePK);
        promoCodeService.savePromoCode(guestJMBG,promoCode);
    }

    private Integer calculatePrice(Integer discount, Integer price) {
        return price - (price*discount/100);
    }


}
