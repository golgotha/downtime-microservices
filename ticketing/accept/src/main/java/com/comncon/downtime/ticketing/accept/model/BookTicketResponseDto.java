package com.comncon.downtime.ticketing.accept.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookTicketResponseDto implements Serializable {
    private Long ticketId;
}
