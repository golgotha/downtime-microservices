package com.comncon.downtime.scheduler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDto implements Serializable {
    private Long eventId;
    private Long startTime;
    private Long finishTime;
}
