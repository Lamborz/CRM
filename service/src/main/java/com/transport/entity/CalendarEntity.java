package com.transport.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by AK on 7/22/2016.
 */
@Data
public class CalendarEntity {
    private String title;
    private Date start;

    public CalendarEntity(String title, Date start) {
        this.title = title;
        this.start = start;
    }
}


