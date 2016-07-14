package com.transport.service;

import com.transport.dto.VehicleDTO;
import com.transport.model.Vehicle;
import com.transport.repository.VehicleRepository;
import com.transport.util.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim Zagorodskiy on 7/14/2016.
 */
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAvailableVehicleByPeriodByDate(Long date) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.addAll(vehicleRepository.findAllByPeriod(TimeUtil.getStartOfTheDay(date), TimeUtil.getEndOfTheDay(date)));
        return vehicles;
    }

    @Override
    public List<Vehicle> getAvailableVehicleByPeriodByDateAndHalfOfADay(Long day) {
        return null;
    }

    @Override
    public List<VehicleDTO> getPreparedListOfAvailableVehicleByDay(Long day) {
        return null;
    }

    @Override
    public List<VehicleDTO> getPreparedListOfAvailableAndPossibleVehicleByDay(Long day) {
        List<Vehicle> vehicles = getAvailableVehicleByPeriodByDate(day);

        return null;
    }
}
