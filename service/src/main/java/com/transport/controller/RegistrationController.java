package com.transport.controller;

import com.transport.form.RegistrationForm;
import com.transport.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 1 on 6/13/2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)

    public ModelAndView register(ModelAndView model) {
        model.addObject("registrationForm", new RegistrationForm());
        model.setViewName("registration");
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)

    public ModelAndView register1(@ModelAttribute RegistrationForm registrationForm) {
        registrationService.addEmployee(registrationForm);
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin");
        return model;
    }
}