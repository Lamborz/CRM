package com.transport.converter;

import com.transport.dto.VehicleDTO;
import com.transport.model.BookedTime;
import com.transport.model.Vehicle;
import com.transport.repository.BookedTimeRepository;
import com.transport.util.time.TimeUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс конвертер для конвертирования VehicleEntity в
 * VehicleDTO
 * Created by Maksim Zagorodskiy on 7/14/2016.
 */
@Component
public class VehicleConverterImpl implements VehicleConverter {
    @Autowired
    private BookedTimeRepository bookedTimeRepository;

    /**
     * Метод добавляет представление транспортного средства в виде строки,
     * например: "Van, reg. number: 6TBS558, All day(AM/PM)"
     * а так же добавляет id траснпортного средства
     *
     * @param vehicle
     * @return
     */
    @Override
    public VehicleDTO convertVehicleToVehicleDTO(Vehicle vehicle, Long data) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setTransportDetails(getAvailableHalfADayByDate(vehicle, data));
        return new VehicleDTO();
    }

    /**
     * Метод возвращает диапазоны дня в течении которой доступен транспорт(AM/PM)
     * виде строки
     *
     * @param date
     * @return
     */
    private String getAvailableHalfADayByDate(Vehicle vehicle, Long date) {
        Set<String> halfsAday = new TreeSet<String>();

        List<BookedTime> bookedTimes = bookedTimeRepository.findByVehicleIdAndDateBetween(vehicle.getId(), TimeUtil.getStartOfTheDay(date),
                TimeUtil.getEndOfTheDay(date));

        if(bookedTimes.isEmpty()) {
            return "AM, PM";
        } else if(bookedTimes.size() == 1){

        } else

        for (int i = 0; i < bookedTimes.size(); i++) {
            Long finishPeriod = bookedTimes.get(i).getFinishPeriod();
            halfsAday.add(getHalfADayByTime(finishPeriod));
        }
        String result = halfsAday.toString();
        return result.substring(1, result.length());
    }

    private String getHalfADayByTime(Long finishPeriod) {
        DateTime dateTime = new DateTime(finishPeriod);
        return dateTime.getHourOfDay() > 12 ? "PM" : "AM";
    }

}
