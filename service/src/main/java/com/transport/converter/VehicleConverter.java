package com.transport.converter;

import com.transport.dto.VehicleDTO;
import com.transport.model.Vehicle;

/**
 * Created by Maksim Zagorodskiy on 7/15/2016.
 */
public interface VehicleConverter {
    VehicleDTO convertVehicleToVehicleDTO(Vehicle vehicle, Long data);
}
