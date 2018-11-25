package com.comncon.downtime.ticketing.accept.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
public class BookTicketRequestDto implements Serializable {

    private Long eventId;
}
