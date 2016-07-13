package com.transport.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
@Entity
@Data
@Table(name="booked_time")
public class BookedTime {
    @Id
    @GeneratedValue
    Integer id;
    Long startPeriod;
    Long finishPeriod;

}
