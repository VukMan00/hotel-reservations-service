package io.swagger.service;

import io.swagger.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.swagger.api.resttemplate.Constants;

@Service
public class GuestService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public GuestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public void registrationGuest(Guest guest) {
        HttpEntity<Guest> requestEntity = new HttpEntity<>(guest, headers);

        restTemplate.postForEntity(
                Constants.GUESTS_URL, requestEntity, Void.class);
    }

    public Guest getGuest(String guestJMBG) {
        ResponseEntity<Guest> responseEntity = restTemplate.getForEntity(Constants.GUESTS_URL + "/" + guestJMBG, Guest.class);
        return responseEntity.getBody();
    }
}
