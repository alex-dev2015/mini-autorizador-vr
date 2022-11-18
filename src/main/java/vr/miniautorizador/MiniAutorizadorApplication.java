package vr.miniautorizador;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniAutorizadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniAutorizadorApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("Api Mini Autorizador") String description){
        return new OpenAPI()
                .info(new Info()
                        .title(description)
                        .version("1.0")
                        .termsOfService("http://suagger.io/terms")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
