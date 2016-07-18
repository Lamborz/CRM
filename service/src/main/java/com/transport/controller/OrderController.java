package com.transport.controller;


import com.transport.converter.OrderFormConverter;
import com.transport.converter.PaymentsDetailsConverter;
import com.transport.email.SmtpMailSender;
import com.transport.form.OrderForm;
import com.transport.form.PaymentDetailsForm;
import com.transport.model.Order;
import com.transport.service.OrderService;
import com.transport.util.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by 1 on 6/9/2016.
 */
@Controller
public class OrderController extends BaseController {
    @Autowired
    private SmtpMailSender smtpMailSender;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderFormConverter orderFormConverter;
    @Autowired
    private PaymentsDetailsConverter paymentsDetailsConverter;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView model) {
        model.addObject("orderForm", new OrderForm());
        model.addObject("paymentsDetailsForm", new PaymentDetailsForm());
        FormUtil.setEnumsToOrderModel(model);
        model.setViewName("/order");
        return model;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView register1( String paymentsDetailsForm, String orderForm ) throws UnsupportedEncodingException {

        String decodedOrderForm = URLDecoder.decode(orderForm, "UTF-8");
        String decodedPaymentsForm = URLDecoder.decode(paymentsDetailsForm, "UTF-8");

        Order order = orderService.addOrder(orderFormConverter.convertToObject(decodedOrderForm),paymentsDetailsConverter.convertStringToObject(decodedPaymentsForm));
        try {
            smtpMailSender.sent(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView model = new ModelAndView();
        model.addObject("paymentsDetailsForm", new PaymentDetailsForm());

        model.setViewName("/order");
        return model;
    }

}
