package com.comncon.downtime.ticketing.accept.controller;

import com.comncon.downtime.ticketing.accept.model.BookTicketRequestDto;
import com.comncon.downtime.ticketing.accept.model.BookTicketResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        response.setTicketId((long) (Math.random() * 100));
        return response;
    }
}
