package com.transport.service;

import com.transport.model.Vehicle;

import java.util.List;

/**
 * Интерфейс описывающий методы для работы с транспортными средствами
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
public interface VehicleService {

    List<Vehicle> getAvailableTransport();

    }
