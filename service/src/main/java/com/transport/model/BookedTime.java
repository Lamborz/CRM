package com.transport.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
@Entity
@Data
@Table(name="booked_time")
@EqualsAndHashCode()
public class BookedTime {
    @Id
    @GeneratedValue
    Integer id;
    Long startPeriod;
    Long finishPeriod;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle")
    Vehicle vehicle;

}
