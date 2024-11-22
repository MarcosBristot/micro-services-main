package br.edu.atitus.paradigma.apigatewayservice.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    RouteLocator getRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(rota -> rota
                        .path("/get")
                        .filters(f -> f
                                .addRequestHeader("Usuario","Marcos Bristot")
                                .addResponseHeader("Usuario","Marcos Bristot"))
                        .uri("http://httpbin.org"))
                .route(rota -> rota
                        .path("/cambio-service/**")
                        .filters(f -> f
                                .addRequestHeader("Usuario", "Marcos Britot")
                                .addResponseHeader("Usuario","Marcos Bristot"))
                        .uri("lb://cambio-service"))
                .route(rota -> rota
                        .path("/produto-service/**")
                        .filters(f -> f
                                .addRequestHeader("Usuario", "Marcos Bristot")
                                .addResponseHeader("Usuario","Marcos Bristot"))
                        .uri("lb://produto-service"))
                .route(rota -> rota
                        .path("/saudacao-service/**")
                        .filters(f -> f
                                .addRequestHeader("Usuario", "Marcos Bristot")
                                .addResponseHeader("Usuario","Marcos Bristot"))
                        .uri("lb://saudacao-service"))
                .build();
    }
}
