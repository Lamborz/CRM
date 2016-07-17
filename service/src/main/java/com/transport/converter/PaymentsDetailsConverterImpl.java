package com.transport.converter;

import com.transport.form.PaymentDetailsForm;
import org.springframework.stereotype.Component;

/**
 * Created by Maksim Zagorodskiy on 7/17/2016.
 */
@Component
public class PaymentsDetailsConverterImpl implements PaymentsDetailsConverter  {

    public PaymentDetailsForm convertStringToObject(String detailsString){
        PaymentDetailsForm paymentDetailsForm = new PaymentDetailsForm();
        //paymentDetailsForm.s

        return paymentDetailsForm;
    }

}
