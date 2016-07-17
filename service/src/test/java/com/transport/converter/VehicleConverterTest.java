package com.transport.converter;

import com.transport.ServiceApplication;
import com.transport.repository.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Maksim Zagorodskiy on 7/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@WebAppConfiguration
public class VehicleConverterTest {

    @Autowired
    private VehicleConverter vehicleConverter;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testVehicleConverter(){
        //vehicleConverter.convertVehicleToVehicleDTO();
    }

}
