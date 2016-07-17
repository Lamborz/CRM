package com.transport.dto;

import lombok.Data;

/**
 * Класс для передачи данных после обработки первичной информации PaymentDetailsForm из order.html
 * Created by Maksim Zagorodskiy on 7/12/2016.
 */
@Data
public class PaymentDetailsDTO {

    private Double ratePerHour;
    private Double packingMaterials;
    private String packingMaterialsTariff;
    private Double shrinkSum;
    private Double tapeSum;
    private Double heavyItemPrice;
    private Double ddtPrice;
    private Double storagePrice;
    private Double totalPrice;
}
