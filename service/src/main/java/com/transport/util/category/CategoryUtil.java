package com.transport.util.category;

import com.transport.enums.Company;
import org.joda.time.DateTime;

/**
 * Класс с утилитными методами связынными со времнем
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
public class CategoryUtil {
    //TODO если компании будут меняться то необходимо придумать и реализовать общий механизм установки и получения тарифов для всех компаний, текущее решение - "временное"

    private CategoryUtil() {

    }

    /**
     * Метод возвращает категорию в зависимости от
     * даты для RoyalMoving
     * @param date
     * @return
     */
    public static int getRoyalMovingPriceCategoryByDay(DateTime date) {

        int category;

        if (!checkDateByPeriod(date, 5, 25)) {
            category = 4;
        } else {
            category = getCategoryBySimpleDay(date);
        }

        return category;
    }

    private static int getCategoryBySimpleDay(DateTime date) {
        int dayOfWeek;
        switch (date.getDayOfWeek()) {
            case 1:
                dayOfWeek = 1;
                break;
            case 2:
                dayOfWeek = 1;
                break;
            case 3:
                dayOfWeek = 1;
                break;
            case 4:
                dayOfWeek = 1;
                break;
            case 5:
                dayOfWeek = 2;
                break;
            case 6:
                dayOfWeek = 2;
                break;
            case 7:
                dayOfWeek = 3;
                break;
            default:
                dayOfWeek = 3;
        }
        return dayOfWeek;
    }


    /**
     * Метод проверяет попадает ли переданнiy den в  диапазон prices between 5 and 25 day.
     * if the day between 5 and 25 values is true if not values is false
     *
     * @param date   дата, которуб необходимо проверить
     * @param start  начальная дата периода
     * @param finish конечная дата периода
     * @return
     */
    private static boolean checkDateByPeriod(DateTime date, int start, int finish) {
        int dayOfMonth = date.getDayOfMonth();

        return dayOfMonth > start && dayOfMonth < finish ;
    }

    /**
     * Метод выбирает необходимую категорию в зависимости от даты
     * и названия компании
     * @param date
     * @param companyName
     * @return
     */
    public static int getCategoryByDateAndCompanyNameAndType(DateTime date, String companyName, int type){
        int category;
        Company company = Company.valueOf(companyName);
        switch (company){
            case  ROYAL_MOVING : category = getRoyalMovingPriceCategoryByDay(date) ;
                break;
            case LIONS_MOVING: category = type;
                break;
            case SHARK_MOVING:
            case PACIFIC_MOVING: category = getCategoryBySimpleDay(date) ;
                break;
            default: category = 1;
        }

        return category;
    }
}
