package com.comncon.downtime.scheduler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Valery Kantor
 * mailto: valery.kantor@gmail.com
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_time")
    private Date finishTime;
}
