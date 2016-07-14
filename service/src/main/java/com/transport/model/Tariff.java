package com.transport.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Maksim Zagorodskiy on 7/10/2016.
 */
@Entity
@Data
@Table(name="tariff_entity")
public class Tariff {
    @Id
    @GeneratedValue
    private Integer id;
    //standard or all inclusive, start and finish month, etc...
    private Integer tariffType;
    private String name;
    @Column(name="two_movers")
    private Integer twoMoversPrice;
    @Column(name="three_movers")
    private Integer threeMoversPrice;
    @Column(name="four_movers")
    private Integer fourMoversPrice;
    @Column(name="five_movers")
    private Integer fiveMoversPrice;
    @Column(name="cash_pay")
    private Integer cashPay;
    @Column(name="not_cash_pay")
    private Double notCashPay;
    @Column(name="day_category_one")
    private Integer dayCategoryOne;

    @Column(name="day_category_two")
    private Integer dayCategoryTwo;
    //Sunday
    @Column(name="day_category_three")
    private Integer dayCategoryThree;
    @Column(name="service_charge")
    private Integer serviceCharge;
    @Column(name="shrink_wrap")
    private Double shrinkWrap;
    private Double tape;
    @Column(name="additional_truck_price")
    private Double additionalTruckPrice;
    @Column(name="flat_rate")
    private Double flatRate;
    @Column(name="packing_materials")
    private Double packingMaterials;

}
