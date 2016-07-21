package com.transport.service;

import com.transport.ServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Класс для тестирования методов
 * Created by Maksim Zagorodskiy on 7/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@WebAppConfiguration
public class ManagerServiceTest {
@Autowired
    private ManagerService managerService;
    @Test
    public void  TestGetAllManagerDTOByDate(){
        managerService.getAllManagerDTOByDate(1468797905162L);
    }
}
