package com.transport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Victoria on 6/23/2016.
 */
@Controller
public class CallendarConroller {

    @RequestMapping("/calendar")
    public String calendar() {
        return "calendar";
    }
}
