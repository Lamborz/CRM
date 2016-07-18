package com.transport.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by 1 on 6/4/2016.
 */
@Entity
@Table(name="order_entity")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Integer id ;
    @Column(name="order_number")
    private Integer orderNumber;
    private String company; //enums
    private String fullName;
    private String phoneNumber;
    @Email
    private String mail;

    private String advertisement;
    private String sizeOfMove; //enums
    private String storageSize;
    private boolean isLabor;

    private Integer status; //enums
    private Integer truck; //enums
    private String movers; //enums
    private Long   orderDay;
    private String heavyItem; //enums
    private String serviceCharge;//enums
    private String shrink; //enums
    private String tape; //enums
    private Integer ddt;
    private Integer  rateOrFlat;
    private Integer totalForFirstHours;
    private Double  addExtra;
    private Double  discount; //enums
    private Double  totalPricePerFirstHours;
    private String  fieldForSalesmanComments;
    private String  fieldForManagerComments;
    private Long    followUpDate;



     private Double workTime;        // salaryCount
     private Integer paymentMethod; // SalaryCount
     @Column(name="end_pick_date") // salaryConut
     private Long endPickUpDate; // salaryConut

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    @OneToMany(targetEntity = com.transport.model.Address.class)
    @JoinColumn(name="unloading_address", referencedColumnName="id")
    private Set<Address> unloadingAddress;

    @OneToMany(targetEntity = com.transport.model.Address.class)
    @JoinColumn(name="loading_address", referencedColumnName="id")
    private Set<Address> loadingAddress;

    @Column(name="box_delivered_date")
    private Long boxDeliveredDate;

    //Date for observing and planning of movement by supervisor

    @Column(name="estimate_date")
    private Long estimateDate;

    @Column(name="package_date")
    private Long packageDate;

    @Column(name="start_pickUp_date")
    private Long pickUpDate;

    @Column(name="move_date")
    private Long moveDate;

    @Column(name="storage_date")
    private Long storageDate;

    @Column(name="is_stored")
    private boolean isStored;
    private Long    durationStorage;

    @Column(name="box_quantity")
    private Integer boxQuantity;

}
