package com.comncon.downtime.scheduler.repository;

import com.comncon.downtime.scheduler.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where e.finishTime > current_time")
    List<Event> findEvents();

    @Query("select e from Event e where e.finishTime <= current_time and e.status <> 'FINISHED'")
    List<Event> findExpired();
}
