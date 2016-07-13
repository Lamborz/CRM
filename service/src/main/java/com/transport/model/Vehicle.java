package com.transport.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Victoria on 6/26/2016.
 */
@Entity
@Data
@Table(name="vehicle_entity")
public class Vehicle {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String vehicleRegNumber;
    @OneToMany(targetEntity = BookedTime.class, fetch=FetchType.EAGER)
    @JoinColumn(name="bookingTime", referencedColumnName="id")
    Set<BookedTime> bookingTime;
}
