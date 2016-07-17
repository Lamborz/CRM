package com.transport.converter;

import com.transport.form.OrderForm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс конфертер для преобразования строики запроса в объект OrderForm
 * Created by Maksim Zagorodskiy on 7/17/2016.
 */
@Component
public class OrderFormConverterImpl implements OrderFormConverter {
    private static final String COMPANY = "company";
    private static final String FULL_NAME = "fullName";
    private static final String MAIL = "mail";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String ADVERTISEMENT = "advertisement";
    private static final String SIZE_OF_MOVE = "sizeOfMove";
    private static final String STORAGE_SIZE = "storageSize";
    private static final String MOVE_DATE = "moveDate";
    private static final String PACKING_DATE = "packingDate";
    private static final String ESTIMATE_DATE = "estimateDate";
    private static final String STORAGE_DATE = "storageDate";
    private static final String MOVE_DATE_TIME = "moveDateTime";
    private static final String PACKING_DATE_TIME = "packingDateTime";
    private static final String ESTIMATE_DATE_TIME = "estimateDateTime";

    private static final String IS_LABOR = "isLabor";
    private static final String ZIP_FROM = "zipFrom";
    private static final String ZIP_TO = "zipTo";
    private static final String LOADING_ADDRESS = "loadingAddress";
    private static final String UNLOADING_ADDRESS = "unLoadingAddress";
    private static final String TARIFF = "tariff";


    @Override
    public OrderForm convertToObject(String orderFormString){
        OrderForm orderForm = new OrderForm();
        String[] values= orderFormString.split("&");
        Map<String, String> params = new HashMap<>();
        parseStringToValues(values, params);

        orderForm.setMail(params.get(MAIL));
        orderForm.setCompany(params.get(COMPANY));
        orderForm.setLoadingAddress(params.get(LOADING_ADDRESS));
        orderForm.setLoadingAddress(params.get(UNLOADING_ADDRESS));
        //TODO Карим, тут нужно засетить все остальные поля...

        return orderForm;
    }

    private void parseStringToValues(String[] values, Map<String, String> params) {
        String value;
        for(String pair: values){
            String[] entry = pair.split("=");
            if(entry.length == 1) {
                value = "";
            } else {
                value = entry[1];
            }
            params.put(entry[0], value);
        }
    }
}
