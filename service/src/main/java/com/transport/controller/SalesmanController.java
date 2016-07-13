package com.transport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by AK on 7/7/2016.
 */
@Controller
public class SalesmanController {
    @RequestMapping("/salesman")
    public String salesman() {
        return "salesman";
    }
}
