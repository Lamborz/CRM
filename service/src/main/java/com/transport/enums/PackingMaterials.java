package com.transport.enums;

/**
 * Created by Victoria on 7/3/2016.
 */
public enum PackingMaterials {
    FREE(1),
    EXTRA(2),
    UNKNOWN(3);

    int type;

    public int getI() {
        return type;
    }

    PackingMaterials(int type){
        this.type = type;
    }

}
