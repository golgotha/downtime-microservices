package com.comncon.downtime.ticketing.accept.service;

import com.comncon.downtime.ticketing.accept.Md5;
import com.comncon.downtime.ticketing.accept.Skip32;
import com.comncon.downtime.ticketing.accept.model.BookTicketResponseDto;
import com.comncon.downtime.ticketing.accept.model.Ticket;
import com.comncon.downtime.ticketing.accept.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Service
public class BookTicketService {
    private static final Logger logger = LoggerFactory.getLogger(BookTicketService.class);

    private final Skip32Enc encryptor = new Skip32Enc("ticket");

    private final TicketRepository ticketRepository;

    @Autowired
    public BookTicketService(TicketRepository ticketRepository) throws UnsupportedEncodingException {
        this.ticketRepository = ticketRepository;
    }

    public BookTicketResponseDto bookTicket(Long eventId) {
        final long ticketId = encryptor.encrypt((int) new Date().getTime());
        ticketRepository.save(Ticket.builder()
                .eventId(eventId)
                .id(String.valueOf(ticketId))
                .status(Ticket.Status.CONFIRMED)
                .bookTime(new Date())
                .build());

        BookTicketResponseDto ticket = new BookTicketResponseDto();
        ticket.setTicketId(ticketId);
        return ticket;
    }

    public void finalizeAllTickets(Long eventId) {
        logger.info("Finalizing tickets for event #" + eventId);
        final List<Ticket> tickets = ticketRepository.findByEventId(eventId);
        tickets.stream().peek(ticket -> ticket.setStatus(Ticket.Status.FINALIZED))
                .collect(Collectors.toList())
                .forEach(ticketRepository::save);
    }

    public List<BookTicketResponseDto> findTickets() {
        return ticketRepository.findAll().stream().map(ticket -> {
            BookTicketResponseDto item = new BookTicketResponseDto();
            item.setTicketId(Long.valueOf(ticket.getId()));
            item.setStatus(ticket.getStatus().name());
            item.setEventId(ticket.getEventId());
            return item;
        }).collect(Collectors.toList());
    }

    protected static class Skip32Enc {
        protected static final long RANGE_UPPER_LIMIT = 8589934591l;
        private static final long HALF_RANGE_UPPER_LIMIT = 4294967295l;
        private static final long FIRST_HALF_RANGE_CONST = 2147483648l;
        private static final long SECOND_HALF_RANGE_CONST = 6442450944l;
        private static final int KEY_LENGTH = 10;

        private final byte[] skip32Key;

        public Skip32Enc(final String passphrase) throws UnsupportedEncodingException {
            final MessageDigest messageDigest = Md5.getMd5();
            final byte[] passphraseHash = messageDigest.digest(passphrase.getBytes("UTF-8"));
            skip32Key = new byte[KEY_LENGTH];
            System.arraycopy(passphraseHash, 0, skip32Key, 0, KEY_LENGTH);
        }

        public long encrypt(final long value) {
            if (value <= HALF_RANGE_UPPER_LIMIT) {
                final int encryptedId = Skip32.encrypt((int) (value - FIRST_HALF_RANGE_CONST), skip32Key);
                return encryptedId + FIRST_HALF_RANGE_CONST + 1;
            } else if (value <= RANGE_UPPER_LIMIT) {
                final int encryptedId = Skip32.encrypt((int) (value - SECOND_HALF_RANGE_CONST), skip32Key);
                return encryptedId + SECOND_HALF_RANGE_CONST + 1;
            } else
                throw new IllegalArgumentException("Invalid sequential value: " + value);
        }
    }
}
