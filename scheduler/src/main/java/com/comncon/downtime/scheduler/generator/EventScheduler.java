package com.comncon.downtime.scheduler.generator;

import com.comncon.downtime.scheduler.client.TicketClient;
import com.comncon.downtime.scheduler.model.Event;
import com.comncon.downtime.scheduler.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Service
public class EventScheduler {

    @Autowired
    private EventRepository repository;
    @Autowired
    private EventGenerator eventGenerator;
    @Autowired
    private TicketClient ticketClient;

    @PostConstruct
    public void init() {

    }

    @PreDestroy
    public void destroy() {

    }

    @Scheduled(fixedRate = 60000)
    @Transactional(rollbackFor = Exception.class)
    public void scheduleEvents() {
        List<Event> eventList = repository.findExpired();
        final List<Event> closedEvents = eventList.stream()
                .peek(e -> {
                    e.setStatus(Event.Status.FINISHED);
                    ticketClient.finalizeAllEventTickets(e.getId());
                })
                .collect(Collectors.toList());

        for (int i = 0; i < 5; i++) {
            repository.save(eventGenerator.generate());
        }
    }
}
