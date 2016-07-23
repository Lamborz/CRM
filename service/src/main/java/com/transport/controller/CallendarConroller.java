package com.transport.controller;

import com.transport.entity.CalendarEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Victoria on 6/23/2016.
 */
@Controller
public class CallendarConroller {
    public CallendarConroller() {
    }

    @RequestMapping({"/calendar"})
    public String calendar() {
        return "calendar";
    }

    @RequestMapping(
            value = {"/getCalendarData"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    public ResponseEntity<List<CalendarEntity>> getCalendarData() {
        CalendarEntity calendarEntity1 = new CalendarEntity("event1", new Date((new Date()).getTime()));
        CalendarEntity calendarEntity2 = new CalendarEntity("event2", new Date((new Date()).getTime()));
        List<CalendarEntity> calEntityList = new ArrayList<>();

        calEntityList.add(calendarEntity1);
        calEntityList.add(calendarEntity2);
        System.out.println("return Data!");
        return new ResponseEntity(calEntityList, HttpStatus.OK);
    }
}
