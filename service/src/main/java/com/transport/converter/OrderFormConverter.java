package com.transport.converter;

import com.transport.form.OrderForm;

/**
 * Created by Maksim Zagorodskiy on 7/17/2016.
 */
public interface OrderFormConverter {
    OrderForm convertToObject(String orderFormString);
}
