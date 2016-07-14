package com.transport.converter;

import com.transport.dto.VehicleDTO;
import com.transport.model.Vehicle;

/**
 * Класс конвертер для конвертирования VehicleEntity в
 * VehicleDTO
 * Created by Maksim Zagorodskiy on 7/14/2016.
 */
public class VehicleConverter {

    public static VehicleDTO convertVehicleToVehicleDTO(Vehicle vehicle){
            return new VehicleDTO();
    }
}
