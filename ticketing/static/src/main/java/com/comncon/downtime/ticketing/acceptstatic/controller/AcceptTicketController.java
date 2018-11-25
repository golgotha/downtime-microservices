package com.comncon.downtime.ticketing.acceptstatic.controller;

import com.comncon.downtime.ticketing.acceptstatic.model.BookTicketRequestDto;
import com.comncon.downtime.ticketing.acceptstatic.model.BookTicketResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@RestController
public class AcceptTicketController {

    @PostMapping(value = "book")
    @ResponseBody
    public BookTicketResponseDto acceptTicket(@RequestBody BookTicketRequestDto request) {
        BookTicketResponseDto response = new BookTicketResponseDto();
        response.setTicketId((long) 10);
        return response;
    }
}
