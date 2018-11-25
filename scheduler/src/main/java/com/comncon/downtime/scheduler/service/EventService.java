package com.comncon.downtime.scheduler.service;

import com.comncon.downtime.scheduler.model.Event;
import com.comncon.downtime.scheduler.model.EventDto;
import com.comncon.downtime.scheduler.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<EventDto> getEvents() {
        List<Event> events = eventRepository.findEvents();
        return events.stream().map(e -> {
            EventDto eventDto = new EventDto();
            eventDto.setEventId(e.getId());
            eventDto.setStartTime(e.getStartTime().getTime());
            eventDto.setFinishTime(e.getFinishTime().getTime());
            return eventDto;
        }).collect(Collectors.toList());
    }
}
