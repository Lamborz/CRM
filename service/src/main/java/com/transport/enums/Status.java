package com.transport.enums;

import org.omg.CORBA.UNKNOWN;

/**
 * Created by maksim on 6/4/2016.
 */
public enum Status {

    BOOKED(0),
    IN_PROCESS(1),
    COMPLETED(2),
    SOLD(3),
    UNKNOWN(4);

    private int type;

    Status(int type) {
        this.type = type;
    }

    public static Status getStatusByType(int type) {
        Status result;
        switch (type) {
            case 0:
                result = BOOKED;
                break;
            case 1:
                result = IN_PROCESS;
                break;
            case 2:
                result = COMPLETED;
                break;
            case 3:
                result = SOLD;
            default:
                result = UNKNOWN;
        }
        return result;
    }

    public int getType() {
        return type;
    }
}


