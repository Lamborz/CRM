package com.transport.enums;

/**
 * Created by Victoria on 7/6/2016.
 */
public enum Rate {
    RATE_PER_HOUR(0),
    FLAT_RATE(1),
    UNKNOWN(3);

    int type;

    public int getI() {
        return type;
    }

    Rate(int type){
        this.type = type;
    }
}
