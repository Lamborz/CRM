package com.transport.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by 1 on 6/13/2016.
 */
@Data
public class EmployeeRegistrationForm {
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private boolean enabled;
    private String mail;
    private String phone;
    private String password;
    private Double rate;
    private Double workTime;
    private BigDecimal fine;
    private BigDecimal expenses;
    private BigDecimal salary;
    private BigDecimal bonuses;

}
