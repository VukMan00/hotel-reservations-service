package io.swagger.api.resttemplate;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Constants implements EnvironmentAware {

    public static String BASE_URL;
    public static String GUESTS_URL;
    public static String ROOMS_URL;
    public static String RESERVATIONS_URL;

    @Override
    public void setEnvironment(Environment environment) {
        String hotel_reservations_db_uri = environment.getProperty("HOTEL_RESERVATIONS_SERVICE_DB_URI", "localhost");
        BASE_URL = "http://" + hotel_reservations_db_uri + ":8100" + "/api/hotel-reservations-db/";
        GUESTS_URL = BASE_URL + "guests";
        ROOMS_URL = BASE_URL + "rooms";
        RESERVATIONS_URL = BASE_URL + "reservations";
    }
}