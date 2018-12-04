package com.comncon.downtime.ticketing.accept.controller;

import com.comncon.downtime.ticketing.accept.model.BookTicketRequestDto;
import com.comncon.downtime.ticketing.accept.model.BookTicketResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@RestController
public class AcceptTicketController {

    private static final Logger log = LoggerFactory.getLogger(AcceptTicketController.class);

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @PostMapping(value = "book")
    @ResponseBody
    public BookTicketResponseDto acceptTicket(@RequestBody BookTicketRequestDto requestData, HttpServletRequest request) {
        log.info("Remote Host: " + request.getRemoteHost());
        log.info("Remote Address: " + request.getRemoteAddr());
        log.info("Host header " + request.getHeader("Host"));
        BookTicketResponseDto response = new BookTicketResponseDto();
        response.setTicketId((long) (Math.random() * 100));
        return response;
    }

//    @RequestMapping("/service-instances/{applicationName}")
//    public List<ServiceInstance> serviceInstancesByApplicationName(
//            @PathVariable String applicationName) {
//        return discoveryClient.getInstances(applicationName);
//    }
}
