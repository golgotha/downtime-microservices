package com.comncon.downtime.ticketing.accept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AcceptTicketApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcceptTicketApplication.class, args);
    }
}
