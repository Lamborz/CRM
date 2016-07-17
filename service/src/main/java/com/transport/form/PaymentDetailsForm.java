package com.transport.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Класс содержащий все поля из блока PaymentsDetails
 * для отправки на сервер
 * Created by Maksim Zagorodskiy on 7/9/2016.
 */
@Data
public class PaymentDetailsForm {


    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date moveDate;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date packingDate;
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date storageDate;
    private String paymentMethod;
    private Integer truck;
    private Integer movers;
    private String serviceCharge;
    private String packingMaterial;
    private Integer shrink;
    private Integer tape;
    private Double tapeValue;
    private Double shrinkValue;
    private Double packingMaterialsValue;
    private String rateType;
    private String heavyItem;
    private Double ddt;
    private String totalForFirstHours;
    private String status;
    private String followUpDate;
    private String fieldForSalesmanComments;
    private String fieldForManagerComments;
    private Double discount;
    private String company;
    private String sizeOfMove;
    private String storageSize;
    private Integer zipFrom;
    private Integer zipTo;
    private String tariff;
    private Double ratePerHour;
}
