package com.comncon.downtimw.ticketing.payout.controller;

import com.comncon.downtimw.ticketing.payout.model.PayoutRequestDto;
import com.comncon.downtimw.ticketing.payout.model.PayoutResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Controller
public class PayoutTicketController {

    @PostMapping(value = "ticket")
    @ResponseBody
    public PayoutResponseDto payoutTicket(@RequestBody PayoutRequestDto request) {
        PayoutResponseDto response = new PayoutResponseDto();
        response.setStatus(PayoutResponseDto.Status.PAIDOUT);
        return response;
    }
}
