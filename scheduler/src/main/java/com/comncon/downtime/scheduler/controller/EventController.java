package com.comncon.downtime.scheduler.controller;

import com.comncon.downtime.contracts.EventDto;
import com.comncon.downtime.scheduler.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@RestController
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return eventService.getEvents();
    }

    @GetMapping("/events/{eventId}")
    public EventDto findEvent(@PathVariable Long eventId) {
        logger.info("Request event id #" + eventId);
        return eventService.findEvent(eventId);
    }
}
