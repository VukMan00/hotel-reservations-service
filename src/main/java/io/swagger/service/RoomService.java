package io.swagger.service;

import io.swagger.api.resttemplate.Constants;
import io.swagger.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RoomService {

    private final RestTemplate restTemplate;

    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public RoomService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        headers.setContentType(MediaType.APPLICATION_JSON);
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

    public ResponseEntity<byte[]> getRoomPicture(Integer roomId) {
        Room room = getRoom(roomId);
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(room.getPicture(), headers, HttpStatus.OK);
    }
}
