package com.transport.converter;

import com.transport.form.OrderForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maksim Zagorodskiy on 7/17/2016.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class OrderConverterTest {

    @Test
    public void testConvert(){
        OrderForm orderForm = convertToObject("company=ROYAL_MOVING&sizeOfMove=STUDIO&fullName=&zipcode1=&loadingAddress=&mail=wer&unLoadingAddress=&zipcode2=&phoneNumber=&moveDate=&moveDateTime=&packingDate=&packingDateTime=&advertisement=how_did_you_hear_about_us&estimateDate=&estimateDateTime=");
    }

    public OrderForm convertToObject(String orderFormString){
        OrderForm orderForm = new OrderForm();
        String[] values= orderFormString.split("&");
        Map<String, String> params = new HashMap<>();
        String value;
        for(String pair: values){
            String[] entry = pair.split("=");
            if(entry.length == 1) {
                value = "";
            } else {
                value = entry[1];
            }
            params.put(entry[0], value);
        }

        return orderForm;
    }
}
