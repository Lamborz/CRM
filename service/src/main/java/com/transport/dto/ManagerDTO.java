package com.transport.dto;

import lombok.Data;

/**
 * Created by AK on 7/18/2016.
 */
@Data
public class ManagerDTO {

    private Integer orderNumber;
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private String mail;
    private String sizeOfMove; //enums
    private String storageSize;
    private boolean isLabor;

    private Integer truck; //enums
    private String movers; //enums
    private Long orderDay;
    private String heavyItem; //enums
    private String fieldForManagerComments;
    private String loadingAddress;
    private String unloadingAddress;
    private Integer zipFrom;
    private Integer zipTo;

}
