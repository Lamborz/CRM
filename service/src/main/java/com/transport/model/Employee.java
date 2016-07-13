package com.transport.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by 1 on 6/10/2016.
 */
@Entity
@Table(name = "employee_entity")
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "full_name")
    private String firstName;
    private String lastName;
    private String position;
    private boolean enabled;
    @Email
    @Column(name = "mail", unique = false)
    private String mail;
    private String phone;
    private String password;
    @OneToMany(targetEntity = com.transport.model.Address.class)
    @JoinColumn(name = "employee_address", referencedColumnName = "id")
    private Set<Order> order;
    private Double rate;
    private Double workTime;
    private BigDecimal fine;
    private BigDecimal expenses;
    private BigDecimal salary;
    private BigDecimal bonuses;
}
