package com.comncon.downtime.scheduler.service;

import com.comncon.downtime.contracts.EventDto;
import com.comncon.downtime.scheduler.model.Event;
import com.comncon.downtime.scheduler.repository.EntityNotFoundException;
import com.comncon.downtime.scheduler.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        return events.stream().map(this::convertEvent).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EventDto findEvent(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        Event e = event.orElseThrow(() -> new EntityNotFoundException("Event with id #" + eventId + " not found"));
        return convertEvent(e);
    }

    private EventDto convertEvent(Event e) {
        EventDto eventDto = new EventDto();
        eventDto.setEventId(e.getId());
        eventDto.setStartTime(e.getStartTime().getTime());
        eventDto.setFinishTime(e.getFinishTime().getTime());
        eventDto.setStatus(EventDto.Status.valueOf(e.getStatus().name()));
        eventDto.setServerTime(new Date().getTime());
        return eventDto;
    }
}
