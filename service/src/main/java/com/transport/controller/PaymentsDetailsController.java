package com.transport.controller;

import com.transport.dto.PaymentDetailsDTO;
import com.transport.form.PaymentDetailsForm;
import com.transport.service.handle.PaymentDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для обработки данных payment details отправленных
 * через AJAX
 * Created by user on 7/9/2016.
 */
@RestController
public class PaymentsDetailsController {

    @Autowired
    private PaymentDetailsHandler paymentDetailsHandler;

    @RequestMapping(value = "/payments/details", method = RequestMethod.GET)
    public PaymentDetailsDTO getPaymentsDetails(PaymentDetailsForm paymentsDetailsForm){
        PaymentDetailsDTO detailsDTO =  paymentDetailsHandler.handlePaymentDetailsForm(paymentsDetailsForm);
/*        PaymentDetailsDTO detailsDTO = new PaymentDetailsDTO();
        detailsDTO.setRatePerHour(25.0);*/
        return detailsDTO;
    }
}
