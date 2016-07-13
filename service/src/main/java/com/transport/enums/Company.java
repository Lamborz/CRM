package com.transport.enums;

/**
 * Created by 1 on 6/7/2016.
 */
public enum Company {
    ROYAL_MOVING(1),
    LIONS_MOVING(2),
    SHARK_MOVING(3),
    PACIFIC_MOVING(4),
    MUSCLE_MOVERS(5),
    APPLE_MOVING(6),
    UNKNOWN(7);

    private int type;

    Company(int i) {
        this.type = i;
    }

    public Company getStatusByType(int type) {
        Company result;
        switch (type) {
            case 1:
                result = ROYAL_MOVING;
                break;
            case 2:
                result = LIONS_MOVING;
                break;
            case 3:
                result = SHARK_MOVING;
                break;
            case 4:
                result = PACIFIC_MOVING;
                break;
            case 5:
                result = MUSCLE_MOVERS;
                break;
            case 6:
                result = APPLE_MOVING;
                break;
            default:
                result = UNKNOWN;
        }
        return result;
    }

    public int getType() {
        return type;
    }
}
