package com.transport.service;

import com.transport.dto.ManagerDTO;

import java.util.List;

/**
 * Класс для  работы с сущностями для страницы менеджера
 * Created by AK on 7/19/2016.
 */
public interface ManagerService {
    List<ManagerDTO> getAllManagerDTO();

    /**
     * Метод возвражает все заказы за весь день
     * @param date Любое время дня, за который необходимо найти заказы
     * @return список заказов в виде DTO
     */
    List<ManagerDTO> getAllManagerDTOByDate(Long date);

}
