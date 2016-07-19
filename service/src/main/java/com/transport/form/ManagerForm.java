package com.transport.form;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by AK on 7/18/2016.
 */

@Data
public class ManagerForm implements Serializable {
    private Integer orderNumber;
    private String fullName;
    private String phoneNumber;

    private String sizeOfMove; //enums
    private String storageSize;
    private boolean isLabor;

    private Integer truck; //enums
    private String movers; //enums
    private Long   orderDay;
    private String heavyItem; //enums
    private String  fieldForManagerComments;
}
