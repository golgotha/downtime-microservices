package com.comncon.downtime.ticketing.acceptstatic.controller;

import com.comncon.downtime.ticketing.acceptstatic.model.BookTicketRequestDto;
import com.comncon.downtime.ticketing.acceptstatic.model.BookTicketResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@RestController
public class AcceptTicketController {
    private static final Logger log = LoggerFactory.getLogger(AcceptTicketController.class);

    @PostMapping(value = "book")
    @ResponseBody
    public BookTicketResponseDto acceptTicket(@RequestBody BookTicketRequestDto requestData, HttpServletRequest request) {
        log.info("Remote Host: " + request.getRemoteHost());
        log.info("Remote Address: " + request.getRemoteAddr());
        log.info("Host header " + request.getHeader("Host"));
        BookTicketResponseDto response = new BookTicketResponseDto();
        response.setTicketId((long) 10);
        return response;
    }
}
