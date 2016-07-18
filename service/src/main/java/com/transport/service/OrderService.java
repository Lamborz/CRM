package com.transport.service;

import com.transport.form.OrderForm;
import com.transport.form.PaymentDetailsForm;
import com.transport.model.Order;

/**
 * Created by 1 on 6/7/2016.
 */
public interface OrderService {

    Order addOrder(OrderForm orderForm, PaymentDetailsForm paymentDetailsForm);
    

}
