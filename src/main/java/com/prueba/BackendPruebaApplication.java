package com.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
@OpenAPIDefinition(
        info = @Info(
                title = "API - Prueba",
                version = "r0.0.1",
                description = "API para la gestión documental",
                contact = @Contact(
                        name = "BABEL",
                        email = "jose.debenito@babelgroup.com",
                        url = "https://gitlab.com/"

                ),
                license = @License(
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html",
                        name = "Apache 2.0"
                )))
@SpringBootApplication
public class BackendPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPruebaApplication.class, args);
	}

}
