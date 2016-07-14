package com.transport.dto;

import lombok.Data;

/**
 * Класс DTO для пердачи данных о транспортном средстве на view,
 * где:
 * id-id транспортного средства,
 * transportDetails - строковое предстваление данных об
 * транспортном средстве
 *
 * Created by Maksim Zagorodskiy on 7/14/2016.
 */
@Data
public class VehicleDTO {
    private int id;
    private String transportDetails;
}
