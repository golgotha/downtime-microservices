package com.comncon.downtime.ticketing.accept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@EnableDiscoveryClient
@EnableMongoRepositories
@EnableFeignClients(basePackages={"com.comncon.downtime.ticketing.accept.client"})
@SpringBootApplication
public class AcceptTicketApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcceptTicketApplication.class, args);
    }
}
