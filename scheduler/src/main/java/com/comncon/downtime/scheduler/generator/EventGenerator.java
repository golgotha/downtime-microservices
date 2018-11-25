package com.comncon.downtime.scheduler.generator;

import com.comncon.downtime.scheduler.model.Event;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Component
public class EventGenerator {
    private final int EVENT_DURATION = 60000;

    public Event generate() {
        Event event = new Event();
        Date startTime = new Date(new Date().getTime() + EVENT_DURATION);
        Date finishTime = new Date(startTime.getTime() + EVENT_DURATION);
        event.setStartTime(startTime);
        event.setFinishTime(finishTime);
        return event;
    }
}
