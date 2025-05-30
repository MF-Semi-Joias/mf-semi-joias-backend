package mf_semi_joias_backend.demomf_semi_joias_backend_gateway.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("clientes", r -> r
                        .path("/clientes/**")
                        .uri("http://localhost:8081/"))
                .route("produtos", r -> r
                        .path("/produtos/**")
                        .uri("http://localhost:8082/"))
                .route("auth", r -> r
                        .path("/auth/**")
                        .uri("http://localhost:8081/"))

                .build();


    }
}
