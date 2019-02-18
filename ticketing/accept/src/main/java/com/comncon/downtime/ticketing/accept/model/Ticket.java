package com.comncon.downtime.ticketing.accept.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    private String id;
//    private Long id;
    private Status status;
    private Date bookTime;
    private Long eventId;

    public enum Status {
        CONFIRMED,
        FINALIZED
    }
}
