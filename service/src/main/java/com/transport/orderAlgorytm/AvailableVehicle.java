package com.transport.orderAlgorytm;

/**
 * Created by К on 6/25/2016.
 * Задача: Распределить доступные машины для распределения поступающих заказов.
 * у зказа есть число месяца, вчемя, дистанция(короткая, длинная),
 * количество траков, количество муверов, статус сложности.
 * елси доступных машин нет. Установить заказ в статус продать.
 *
 */



public class AvailableVehicle {

public static void availableVehicleAlgoritm(long date, boolean isDistance, int truckCount, int vanCount) {
    //запрос в бд узнющий количество доступных машин исходя из даты, времени, типа(траки и вэны)
    //
    // Учитывается что работающие машины в утреннее время с 8 до 12, делятся на половину
    // и записываются как доступные для работы в дневное время.
    //
    //
    //для того чтобы задействовать доступную машину на лэйбор(короткая дистанция)
    // производится проверка на доступность вэнов. Если вэны доступны, то назначается
    // вэн. Если не доступен, назначается трак.

}
//    public static void main(String[] args) {
//        Long date;
//        Integer category;
//        int truckCount = 0;
//        int vanCount = 0;
//        boolean vanAvailability;
//        boolean truckAvailability;
//        boolean distance = false;
//        int amTrucks = 2; // узнаём количество назначенных машин из бд.
//        int pmTrucks = 4;
//        int amVan = 1;
//        int pmVan = 2;
//
//        int availableTrucksRepository = 100;
//        int availableVanRepository = 10;
//
//        for(int i = 0;i < availableTrucksRepository;i++ ) {
//            truckCount += i;
//        }
//        for(int i = 0;i < availableVanRepository;i++ ) {
//            vanCount += i;
//        }
//        //прибавляем к текущим счетчикам половину машин назначенных на утро(am)
//        truckCount = truckCount + (amTrucks / 2 );
//        vanCount = vanCount + (amVan / 2);
//
//
//        //Узнаем доступны ли Вэны
//        if(vanCount > 0 && vanCount < 4) {
//            vanAvailability = true;
//
//        } else {
//            vanAvailability = false;
//        }
//
//
//        //Узнаем доступны ли Траки
//        if(truckCount > 0 && vanCount < 10) {
//            truckAvailability = true;
//        } else {
//            vanAvailability = false;
//        }
//
//
//    }

}
