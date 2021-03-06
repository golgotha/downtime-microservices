package com.comncon.downtimw.ticketing.payout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PayoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayoutApplication.class, args);
    }
}
