package com.transport.converter;

import com.transport.form.PaymentDetailsForm;

/**
 * Created by Maksim Zagorodskiy on 7/17/2016.
 */
public interface PaymentsDetailsConverter {
    PaymentDetailsForm convertStringToObject(String detailsString);
}
