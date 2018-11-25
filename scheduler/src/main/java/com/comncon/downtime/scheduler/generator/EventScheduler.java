package com.comncon.downtime.scheduler.generator;

import com.comncon.downtime.scheduler.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    @PostConstruct
    public void init() {

    }

    @PreDestroy
    public void destroy() {

    }

    @Scheduled(fixedRate = 60000)
    @Transactional(rollbackFor = Exception.class)
    public void scheduleEvents() {
        for (int i = 0; i < 10; i++) {
            repository.save(eventGenerator.generate());
        }
    }
}
