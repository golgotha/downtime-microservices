package com.comncon.downtime.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Configuration
@SpringBootApplication
public class GatewayApplication {

    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.host("text1.org")
//                        .uri("http://localhost:8080")
                        .uri("http://accept-ticket:8080")
                )
//                .predicate(host("**.abc.org").and(path("/image/png")))
//                .addResponseHeader("X-TestHeader", "foobar")
//                .and()
//                .route("test2")
//                .uri("http://httpbin.org:80")
//                .predicate(path("/image/webp"))
//                .add(addResponseHeader("X-AnotherHeader", "baz"))
//                .and()
                .build();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
