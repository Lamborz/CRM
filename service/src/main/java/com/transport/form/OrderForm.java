package com.transport.form;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 1 on 6/10/2016.
 */
@Data
public class OrderForm implements Serializable {

    private String company;  //enums
    private String fullName;
    private String mail;
    private String phoneNumber;
    private String advertisement;
    private String sizeOfMove;
    private String storageSize;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date moveDate;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date packingDate;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date estimateDate;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date storageDate;
    @DateTimeFormat(pattern="HH:mm")
    private Date moveDateTime;
    @DateTimeFormat(pattern="HH:mm")
    private Date packingDateTime;
    @DateTimeFormat(pattern="HH:mm")
    private Date estimateDateTime;

    private boolean isLabor;
    private Integer zipFrom;
    private Integer zipTo;
    private String loadingAddress;
    private String unLoadingAddress;
    private String tariff;

}
