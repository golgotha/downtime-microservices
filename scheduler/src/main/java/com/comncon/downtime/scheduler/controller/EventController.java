package com.comncon.downtime.scheduler.controller;

import com.comncon.downtime.scheduler.model.EventDto;
import com.comncon.downtime.scheduler.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return eventService.getEvents();
    }
}
