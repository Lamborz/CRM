package com.transport.enums;

/**
 * Created by maksim on 6/5/2016.
 */
public enum Advertisement {

 how_did_you_hear_about_us(0),
    GOOGLE_ADS(1),
    SEARCH_ENGINE(2),
    YELLOW_PAGES(3),
    FRIENDS(4),
    REFERENCE(5),
    USED_PREVIOUSLY(6),
    ANGIES_LIST(7),
    TRUCK_ADS(8),
    MOSS(9),
    UNKNOWN(10);

    private int type;

    Advertisement(int i) {
        type = i;
    }

    public Advertisement valueOf(int type) {
        Advertisement result;
        switch (type) {
            case 0:
                result = how_did_you_hear_about_us;
            case 1:
                result = GOOGLE_ADS;
                break;
            case 2:
                result = SEARCH_ENGINE;
                break;
            case 3:
                result = YELLOW_PAGES;
                break;
            case 4:
                result = FRIENDS;
                break;
            case 5:
                result = REFERENCE;
                break;
            case 6:
                result = USED_PREVIOUSLY;
                break;
            case 7:
                result = ANGIES_LIST;
                break;
            case 8:
                result = TRUCK_ADS;
                break;
            case 9:
                result = MOSS;
                break;
            default:
                result = UNKNOWN;
        }
        return result;
    }
}
