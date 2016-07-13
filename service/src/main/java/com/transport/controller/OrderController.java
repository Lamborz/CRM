package com.transport.controller;


import com.transport.form.OrderForm;
import com.transport.form.PaymentDetailsForm;
import com.transport.service.OrderService;
import com.transport.util.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 1 on 6/9/2016.
 */
@Controller
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView model) {
        model.addObject("orderForm", new OrderForm());
        model.addObject("paymentsDetailsForm", new PaymentDetailsForm());
        FormUtil.setEnumsToOrderModel(model);
        model.setViewName("order");
        return model;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ModelAndView register1(@ModelAttribute OrderForm orderForm) {
        orderService.addOrder(orderForm);
        ModelAndView model = new ModelAndView();
        model.addObject("paymentsDetailsForm", new PaymentDetailsForm());
        model.setViewName("/order");
        return model;
    }
}
