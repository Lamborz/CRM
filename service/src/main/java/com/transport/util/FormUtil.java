package com.transport.util;

import com.transport.dto.VehicleDTO;
import com.transport.enums.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс утилитных методов дял работы с формами
 * Created by Maksim Zagorodskiy on 7/9/2016.
 */
public class FormUtil {
    private FormUtil(){

    }

    public static void setEnumsToOrderModel(ModelAndView model){

        List<Advertisement> actualListAds = Arrays.asList(Advertisement.values()).subList(0,Advertisement.values().length-1);
        List<Company> actualListCompany = Arrays.asList(Company.values()).subList(0,Company.values().length-1);
        List<SizeOfMove> actualListSizeOfMove = Arrays.asList(SizeOfMove.values()).subList(0,SizeOfMove.values().length-1);
        List<ServiceCharge> actualListServiceCharge = Arrays.asList(ServiceCharge.values()).subList(0,ServiceCharge.values().length-1);

        List<HeavyItem> actualListHeavyItem = Arrays.asList(HeavyItem.values()).subList(0,HeavyItem.values().length-1);
        List<PackingMaterials> packingMaterials = Arrays.asList(PackingMaterials.values()).subList(0,PackingMaterials.values().length-1);
        List<PaymentMethod> actualListPaymentMethod = Arrays.asList(PaymentMethod.values()).subList(0,PaymentMethod.values().length-1);
        List<Rate> actualListRateOrFlat = Arrays.asList(Rate.values()).subList(0, Rate.values().length-1);
        List<Status> actualListStatus = Arrays.asList(Status.values()).subList(0,Status.values().length-1);
        List<TariffType> tariffs = Arrays.asList(TariffType.values()).subList(0, TariffType.values().length-1);

        VehicleDTO veh1 = new VehicleDTO();
        veh1.setId(1);
        veh1.setTransportDetails("Van, reg num 1231CA, AM");

        VehicleDTO veh2 = new VehicleDTO();
        veh2.setId(2);
        veh2.setTransportDetails("Truck, reg num 1231CA, PM");


        List<VehicleDTO> availableVehicles = new ArrayList<VehicleDTO>();
        availableVehicles.add(veh1);
        availableVehicles.add(veh2);


        model.addObject("ads", actualListAds);
        model.addObject("actualListTruck", Arrays.asList(1, 2, 3, 4, 5, 6));
        model.addObject("actualListMovers", Arrays.asList(2, 3, 4, 5, 6));
        model.addObject("actualListCompany", actualListCompany);
        model.addObject("actualListSizeOfMove", actualListSizeOfMove);
        model.addObject("actualListServiceCharge", actualListServiceCharge);
        model.addObject("actualListShrink", Arrays.asList(1, 2, 3, 4, 5, 6));
        model.addObject("actualListTape", Arrays.asList(1, 2, 3, 4, 5, 6));
        model.addObject("actualListHeavyItem", actualListHeavyItem);
        model.addObject("packingMaterials", packingMaterials);
        model.addObject("actualListPaymentMethod", actualListPaymentMethod);
        model.addObject("actualListRateOrFlat", actualListRateOrFlat);
        model.addObject("actualListStatus", actualListStatus);
        model.addObject("actualListTotalForFirstHours", Arrays.asList(1, 2, 3, 4));
        model.addObject("tariffs", tariffs);
        model.addObject("availableVehicles", availableVehicles);
    }
}
