package io.swagger.api;

import io.swagger.model.Reservation;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-11T08:59:36.048365385Z[GMT]")
@RestController
public class ReservationsApiController implements ReservationsApi {

    private static final Logger log = LoggerFactory.getLogger(ReservationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("roomId") Integer roomId,
                                                  @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Reservation> getReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("roomId") Integer roomId,
                                                      @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Reservation>(objectMapper.readValue("{\n  \"reservationPK\" : {\n    \"jmbg\" : \"jmbg\",\n    \"id\" : 5\n  },\n  \"price\" : 7,\n  \"dateTo\" : \"2000-01-23\",\n  \"guest\" : {\n    \"reservations\" : [ null, null ],\n    \"promoCodes\" : [ {\n      \"promoCodePK\" : {\n        \"jmbg\" : \"jmbg\",\n        \"id\" : 5\n      },\n      \"discount\" : 2,\n      \"used\" : true\n    }, {\n      \"promoCodePK\" : {\n        \"jmbg\" : \"jmbg\",\n        \"id\" : 5\n      },\n      \"discount\" : 2,\n      \"used\" : true\n    } ],\n    \"credentials\" : {\n      \"password\" : \"password\",\n      \"typeGuest\" : \"User\",\n      \"username\" : \"username\"\n    },\n    \"name\" : \"name\",\n    \"jmbg\" : \"jmbg\",\n    \"dateOfBirth\" : \"2000-01-23\",\n    \"lastname\" : \"lastname\"\n  },\n  \"dateFrom\" : \"2000-01-23\",\n  \"email\" : \"email\",\n  \"token\" : \"token\"\n}", Reservation.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Reservation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Reservation>> getRoomReservations(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("roomId") Integer roomId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Reservation>>(objectMapper.readValue("[ {\n  \"reservationPK\" : {\n    \"jmbg\" : \"jmbg\",\n    \"id\" : 5\n  },\n  \"price\" : 7,\n  \"dateTo\" : \"2000-01-23\",\n  \"guest\" : {\n    \"reservations\" : [ null, null ],\n    \"promoCodes\" : [ {\n      \"promoCodePK\" : {\n        \"jmbg\" : \"jmbg\",\n        \"id\" : 5\n      },\n      \"discount\" : 2,\n      \"used\" : true\n    }, {\n      \"promoCodePK\" : {\n        \"jmbg\" : \"jmbg\",\n        \"id\" : 5\n      },\n      \"discount\" : 2,\n      \"used\" : true\n    } ],\n    \"credentials\" : {\n      \"password\" : \"password\",\n      \"typeGuest\" : \"User\",\n      \"username\" : \"username\"\n    },\n    \"name\" : \"name\",\n    \"jmbg\" : \"jmbg\",\n    \"dateOfBirth\" : \"2000-01-23\",\n    \"lastname\" : \"lastname\"\n  },\n  \"dateFrom\" : \"2000-01-23\",\n  \"email\" : \"email\",\n  \"token\" : \"token\"\n}, {\n  \"reservationPK\" : {\n    \"jmbg\" : \"jmbg\",\n    \"id\" : 5\n  },\n  \"price\" : 7,\n  \"dateTo\" : \"2000-01-23\",\n  \"guest\" : {\n    \"reservations\" : [ null, null ],\n    \"promoCodes\" : [ {\n      \"promoCodePK\" : {\n        \"jmbg\" : \"jmbg\",\n        \"id\" : 5\n      },\n      \"discount\" : 2,\n      \"used\" : true\n    }, {\n      \"promoCodePK\" : {\n        \"jmbg\" : \"jmbg\",\n        \"id\" : 5\n      },\n      \"discount\" : 2,\n      \"used\" : true\n    } ],\n    \"credentials\" : {\n      \"password\" : \"password\",\n      \"typeGuest\" : \"User\",\n      \"username\" : \"username\"\n    },\n    \"name\" : \"name\",\n    \"jmbg\" : \"jmbg\",\n    \"dateOfBirth\" : \"2000-01-23\",\n    \"lastname\" : \"lastname\"\n  },\n  \"dateFrom\" : \"2000-01-23\",\n  \"email\" : \"email\",\n  \"token\" : \"token\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Reservation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Reservation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> saveRoomReservation(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("roomId") Integer roomId,
                                                    @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("guestJMBG") String guestJMBG,
                                                    @Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Reservation body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }
}
