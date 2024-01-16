package io.swagger.service;

import io.swagger.api.resttemplate.Constants;
import io.swagger.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class PromoCodeService {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers = new HttpHeaders();

    private final int[] discounts = {5,10,15,20};

    @Autowired
    public PromoCodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public List<PromoCode> getGuestPromoCodes(String guestJMBG) {
        String url = Constants.GUESTS_URL +
                "/" +
                guestJMBG +
                "/promoCodes";
        ParameterizedTypeReference<List<PromoCode>> responseType = new ParameterizedTypeReference<List<PromoCode>>() {};

        ResponseEntity<List<PromoCode>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,responseType);
        return responseEntity.getBody();
    }

    public void savePromoCode(String guestJMBG, PromoCode promoCode) {
        promoCode.setDiscount(getRandomDiscount());
        HttpEntity<PromoCode> requestEntity = new HttpEntity<>(promoCode, headers);
        restTemplate.postForEntity(
                Constants.GUESTS_URL + "/" + guestJMBG + "/promoCodes", requestEntity, Void.class);
    }

    private Integer getRandomDiscount() {
        Random random = new Random();
        int discountIndex = random.nextInt(discounts.length);
        return discounts[discountIndex];
    }

    public void updatePromoCode(String guestJMBG, PromoCode promoCode) {
        promoCode.setUsed(true);
        HttpEntity<PromoCode> requestEntity = new HttpEntity<>(promoCode, headers);
        restTemplate.postForEntity(
                Constants.GUESTS_URL + "/" + guestJMBG + "/promoCodes", requestEntity, Void.class);
    }
}
