package com.transport.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Victoria on 6/26/2016.
 */
@Entity
@Data
@Table(name="vehicle_entity")
@EqualsAndHashCode()
public class Vehicle {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String vehicleRegNumber;
    @OneToMany(mappedBy = "vehicle", fetch=FetchType.LAZY )
    Set<BookedTime> bookedTime;
}
