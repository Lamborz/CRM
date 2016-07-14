package com.transport.util.time;

import org.joda.time.DateTime;

/**
 * Утилитный класс содержащий методы для раобты с временем
 * Created by Maksim Zagorodskiy on 7/14/2016.
 */
public class TimeUtil {
    private TimeUtil(){

    }

    /**
     * Метод возвращает начала дня
     * @param day - время в течении дня, начало которого необходимо найти
     * @return самое начало дня
     */
    public static Long getStartOfTheDay(Long day){
        DateTime dateTime = new DateTime(day);
        dateTime.withTime(0, 0, 0, 0);
        return dateTime.getMillis();
    }

    /**
     * Метод возвращает конец дня
     * @param day - время в течении дня, конец которого необходимо найти
     * @return самый конец дня
     */
    public static Long getEndOfTheDay(Long day){
        DateTime dateTime = new DateTime(day);
        dateTime.withTime(23, 59, 59, 999);
        return dateTime.getMillis();
    }
}

