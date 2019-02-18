package com.comncon.downtime.scheduler.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@FeignClient("accept-ticket-service")
public interface TicketClient {
    @RequestMapping(value = "/accept/finalizeAll/{eventId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    void finalizeAllEventTickets(@PathVariable("eventId") Long eventId);
}
