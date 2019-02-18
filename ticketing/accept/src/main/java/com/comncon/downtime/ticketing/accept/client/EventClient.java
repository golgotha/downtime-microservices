package com.comncon.downtime.ticketing.accept.client;

import com.comncon.downtime.contracts.EventDto;
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
@FeignClient("event-scheduler-service")
public interface EventClient {
    @RequestMapping(value = "/scheduler/events/{eventId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    EventDto getEvent(@PathVariable("eventId") Long eventId);
}
