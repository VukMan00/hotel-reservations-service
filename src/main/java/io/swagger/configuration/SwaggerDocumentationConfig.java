package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-01-11T08:59:36.048365385Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Hotel Rezervation API")
                .description("# About API **Hotel FONsion** is one of the best hotels in Belgrade. Located nearby Slavija, hotel FONsion is positioned in one of the most urban and popular places in Belgrade. FONsion has 5 stars grade and is also a home to a number of buissness and corporate managers, directors, CEOs, CFOs and so on. ")
                .termsOfService("")
                .version("0.0.1")
                .license(new License()
                    .name("HotelRezervation 2.0")
                    .url("https://www.eazyshop.com/licenses/LICENSE-2.0.html"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("vuk.manojlovic@levi9.com")));
    }

}
