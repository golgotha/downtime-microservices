package com.comncon.downtime.ticketing.accept.repository;

import com.comncon.downtime.ticketing.accept.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {
    Optional<Ticket> findById(String id);
    List<Ticket> findByEventId(Long eventId);

}
