package com.comncon.downtime.contracts;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDto implements Serializable {
    private Long eventId;
    private Long startTime;
    private Long finishTime;
    private Status status;
    private Long serverTime;

    public enum Status {
        ANNOUNCEMENT,
        PROGRESS,
        RESULT,
        FINISHED
    }
}
