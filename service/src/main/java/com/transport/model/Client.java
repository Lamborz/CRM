package com.transport.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * Created by 1 on 6/9/2016.
 */
@Entity
@Table(name = "client_entity")
@Data
public class Client {
    @Id
    @GeneratedValue
    private Integer id;
    private boolean enabled;
    @Column(name="full_name")
    private String fullName;

    @Email
    @Column(name="mail", unique = true)
    private String mail;
    private String phone;
    private String mailMessage;
    private Double rate;
    private Double workTime;


}
