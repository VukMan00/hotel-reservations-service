package io.swagger.service;

import io.swagger.api.resttemplate.Constants;
import io.swagger.model.PromoCode;
import io.swagger.model.Reservation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReservationService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();

    public ReservationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public void deleteReservation(Integer roomId, String guestJMBG) {
        String url = Constants.RESERVATIONS_URL +
                "/rooms/" + roomId +
                "/guests/" + guestJMBG;
        restTemplate.delete(url);
    }

    public Reservation getReservation(Integer roomId, String guestJMBG) {
        String url = Constants.RESERVATIONS_URL +
                "/rooms/" + roomId +
                "/guests/" + guestJMBG;
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
}
