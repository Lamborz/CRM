package com.transport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AK on 7/7/2016.
 */
@Controller
public class ManagerController {
    @RequestMapping("/manager")
    public String manager(){
        return "manager";
    }
}
