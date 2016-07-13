package com.transport.service.handle;

import com.transport.dto.PaymentDetailsDTO;
import com.transport.form.PaymentDetailsForm;

/**
 * Created by Maksim Zagorodskiy on 7/11/2016.
 */
public interface PaymentDetailsHandler {

    /**
     * Метод обрабатывает получененную первичную информацию Payment Details
     * @param paymentsDetailsForm
     * @return заполненный DTO для отображения
     */
    PaymentDetailsDTO handlePaymentDetailsForm(PaymentDetailsForm paymentsDetailsForm);
}
