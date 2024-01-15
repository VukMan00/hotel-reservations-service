package io.swagger.service;

import io.swagger.api.resttemplate.Constants;
import io.swagger.model.Room;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RoomService {

    private final RestTemplate restTemplate;

    public RoomService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Room getRoom(Integer roomId){
        ResponseEntity<Room> responseEntity = restTemplate.getForEntity(Constants.ROOMS_URL + "/" + roomId, Room.class);
        return responseEntity.getBody();
    }

    public List<Room> getRooms() {
        ParameterizedTypeReference<List<Room>> responseType = new ParameterizedTypeReference<List<Room>>() {};

        ResponseEntity<List<Room>> responseEntity = restTemplate.exchange(Constants.ROOMS_URL, HttpMethod.GET,null,responseType);
        return responseEntity.getBody();
    }
}
