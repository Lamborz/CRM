package com.transport.enums;

/**
 * Created by Maksim Zagorodskiy on 7/11/2016.
 */
public enum TariffType {
    STANDARD(1),
    ALL_INCLUSIVE(2),
    UNKNOWN(0);

    int type;

    TariffType(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static TariffType getByIndex(Integer index){
        if(index != null && index != 0){
            for(TariffType tariff :  TariffType.values()){
                if(tariff.getType() == index ){
                    return tariff;
                }
            }
            return UNKNOWN;
        }else {
            return UNKNOWN;
        }
    }
}
