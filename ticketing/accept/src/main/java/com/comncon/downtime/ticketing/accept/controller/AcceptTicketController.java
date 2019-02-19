package com.comncon.downtime.ticketing.accept.controller;

import com.comncon.downtime.contracts.EventDto;
import com.comncon.downtime.ticketing.accept.client.EventClient;
import com.comncon.downtime.ticketing.accept.model.BookTicketRequestDto;
import com.comncon.downtime.ticketing.accept.model.BookTicketResponseDto;
import com.comncon.downtime.ticketing.accept.service.BookTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@RestController
public class AcceptTicketController {

    private static final Logger log = LoggerFactory.getLogger(AcceptTicketController.class);

    private final KafkaTemplate<String, BookTicketRequestDto> kafkaTemplate;
    private final EventClient eventClient;
    private final BookTicketService bookTicketService;

    @Autowired
    public AcceptTicketController(KafkaTemplate<String, BookTicketRequestDto> kafkaTemplate,
                                  EventClient eventClient, BookTicketService bookTicketService) {
        this.kafkaTemplate = kafkaTemplate;
        this.eventClient = eventClient;
        this.bookTicketService = bookTicketService;
    }

    @PostMapping(value = "book")
    @ResponseBody
    public BookTicketResponseDto acceptTicket(@RequestBody BookTicketRequestDto requestData, HttpServletRequest request) {
        log.info("Remote Host: " + request.getRemoteHost());
        log.info("Remote Address: " + request.getRemoteAddr());
        log.info("Host header " + request.getHeader("Host"));
        EventDto eventDto = eventClient.getEvent(requestData.getEventId());
        if (eventDto.getStatus() == EventDto.Status.ANNOUNCEMENT) {
            BookTicketResponseDto response = bookTicketService.bookTicket(requestData.getEventId());
            kafkaTemplate.send("tickets", requestData);
            return response;
        }

        throw new IllegalStateException("Event closed");
    }

    @PostMapping(value = "/finalizeAll/{eventId}")
    @ResponseBody
    public void finalizeAllEventTickets(@PathVariable Long eventId) {
        bookTicketService.finalizeAllTickets(eventId);
    }

    @GetMapping(value = "/findTickets")
    @ResponseBody
    public List<BookTicketResponseDto> getTickets() {
        return bookTicketService.findTickets();
    }

    @KafkaListener(topics = "tickets")
    public void listener(@Payload BookTicketRequestDto message,
                         @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                         @Header(KafkaHeaders.OFFSET) String offset) {
        log.info("Topic: " + topic + ", Offset: " + offset);
        log.info("Received: " + message);
    }
}
