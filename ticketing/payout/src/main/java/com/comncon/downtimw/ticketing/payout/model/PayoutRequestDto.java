package com.comncon.downtimw.ticketing.payout.model;

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
public class PayoutRequestDto implements Serializable {
    private Long ticketId;
}
