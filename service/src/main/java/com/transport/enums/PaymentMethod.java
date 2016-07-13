package com.transport.enums;

/**
 * Created by 1 on 6/7/2016.
 */
public enum PaymentMethod {
    CASH(1), CREDIT_CART(2), CHEQUE(3), PAYPAL(4), UNKNOWN(5);

    private int type;

    PaymentMethod(int i) {
        this.type = i;
    }

    public PaymentMethod getStatusByType(int type) {
        PaymentMethod result;
        switch (type) {
            case 1:
                result = CASH;
                break;
            case 2:
                result = CREDIT_CART;
                break;
            case 3:
                result = CHEQUE;
                break;
            case 4:
                result = PAYPAL;
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
