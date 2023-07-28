package com.durgesh.BloggingPlatform.security;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name = "Durgesh Sonawale",
                email = "durgeshsonawale86@gmail.com",
                url = "https://github.com/durgeshsonawale"),
                description = "swagger documentation for my blog-api springboot project",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://github.com/durgeshsonawale"
                ),
                termsOfService = "terms of service"

        )
)
@SecurityScheme(
      name = "AuthenticationToken" ,
        description = "please login using /auth/login api and get jwt token and enter that token here : ",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in= SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
