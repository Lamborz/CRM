package com.transport.service;

import com.transport.dto.VehicleDTO;
import com.transport.model.Vehicle;

import java.util.List;

/**
 * Интерфейс описывающий методы для работы с транспортными средствами
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
public interface VehicleService {
    /**
     * Метод возвращает список всех доступных транспортных средств
     * доступных в заданном периоде
     * @return
     */
    List<Vehicle> getAvailableVehicleByPeriodByDate(Long date);

    /**
     * Метод возвращает список всех доступных транспортных средств
     * за заданную дату и время дня.
     * доступных в заданном периоде
     * @param day - день за который необходимо получить список
     *            доступных транспортных средств
     * @return
     */
    List<Vehicle> getAvailableVehicleByPeriodByDateAndHalfOfADay(Long day);


    /**
     * Метод возвращает подготовленный DTO со списком доступных транспортных средств
     * за заданный денб для отображения на view
     * @param day
     * @return
     */
    List<VehicleDTO> getPreparedListOfAvailableVehicleByDay(Long day);


    /**
     * Метод возвращает подготовленный список доступных транспортных средств
     * и последний пунктом, занятые на первую половину дня машины, но потенциально
     * доступные во второй половине дня, а именно 50% от занятых
     * @param day
     * @return
     */
    List<VehicleDTO> getPreparedListOfAvailableAndPossibleVehicleByDay(Long day);
}
