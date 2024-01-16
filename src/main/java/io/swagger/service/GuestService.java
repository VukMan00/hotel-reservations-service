package io.swagger.service;

import io.swagger.model.Guest;
import io.swagger.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.swagger.api.resttemplate.Constants;

import java.util.List;

@Service
public class GuestService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();

    private final PromoCodeService promoCodeService;

    @Autowired
    public GuestService(RestTemplate restTemplate, PromoCodeService promoCodeService) {
        this.restTemplate = restTemplate;
        this.promoCodeService = promoCodeService;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public void registrationGuest(Guest guest) {
        HttpEntity<Guest> requestEntity = new HttpEntity<>(guest, headers);

        restTemplate.postForEntity(
                Constants.GUESTS_URL, requestEntity, Void.class);
    }

    public Guest getGuest(String guestJMBG){
        ResponseEntity<Guest> responseEntity = restTemplate.getForEntity(Constants.GUESTS_URL + "/" + guestJMBG, Guest.class);
        return responseEntity.getBody();
    }

    public List<PromoCode> getPromoCodes(String guestJMBG) {
        return promoCodeService.getGuestPromoCodes(guestJMBG);
    }

    public void saveGuestPromoCode(String guestJMBG, PromoCode promoCode) {
        Guest guest = getGuest(guestJMBG);
        promoCode.setCode("code-"+guestJMBG+"-"+guest.getCredentials().getUsername());
        promoCodeService.savePromoCode(guestJMBG,promoCode);
    }
}
