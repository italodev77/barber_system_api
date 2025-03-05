package dev.mivas.BarberSystem.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenAPI(){

        Contact contact = new Contact();

        contact.name("Italo");
        contact.email("italo_ariel_dev77@outlook.com");
        contact.setUrl("https://github.com/italodev77");


        Info info = new Info();

        info.title("Barber_api");
        info.version("v1");
        info.description("Aplicação para gerenciamento de barbearias");

        return new OpenAPI().info(info);
    }
}
