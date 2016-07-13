package com.transport.enums;

/**
 * Created by 1 on 6/7/2016.
 */
public enum ServiceCharge {
    ROYAL(0), ANOTHER(1), UNKNOWN(2);

    private int type;

    ServiceCharge(int i) {
        this.type = i;
    }

    public ServiceCharge getStatusByType(int type) {
        ServiceCharge result;
        switch (type) {
            case 1:
                result = ROYAL;
                break;
            case 2:
                result = ANOTHER;
                break;

            default:
                result = ANOTHER;
        }
        return result;
    }

    public int getType() {
        return type;
    }
}
