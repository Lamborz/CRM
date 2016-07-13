package com.transport.controller;

import com.transport.form.LoginForm;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 1 on 6/9/2016.
 */
@Controller
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView model) {

        model.addObject("loginForm", new LoginForm());
        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView register1(@ModelAttribute LoginForm loginForm) {

        ModelAndView model = new ModelAndView();
        model.setViewName("/order");
        return model;
    }
}
