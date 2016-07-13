package com.transport;

import com.transport.model.Address;
import com.transport.model.Client;
import com.transport.model.Employee;
import com.transport.model.Order;
import com.transport.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApplication.class)
@WebAppConfiguration
public class ServiceApplicationTests {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test


    public void contextLoads() {
    }

    @Test
    public void personRepositoryTest() {


        Client client = new Client();

        client.setFirstName("Aram");
        client.setMailMessage("Please help me to moves");
        client.setMail("ClientTest"+ Math.random()+"@gmail.com");
        client.setEnabled(true);
        client.setPhone("+32334223423 ");
        save(client);
    }

    @Test
    public void orderRepositoryTest() {

        Address address = new Address();

        //address.setAddressFrom("691 irolo  aps 1111");
        address.setZip(90005);
        address.setFloor(3);


        Address addressTwo = new Address();

//        addressTwo.setAddressTo("100 Manhettan  aps 10");
        addressTwo.setZip(90210);
        addressTwo.setFloor(1);


        address = addressRepository.saveAndFlush(address);
        addressTwo = addressRepository.saveAndFlush(addressTwo);

        Set<Address> addresses = new HashSet<Address>();
        addresses.add(address);
        addresses.add(addressTwo);

        Employee employee = new Employee();
        employee.setFirstName("Alex");
        employee.setPassword("alexpw");
        employee.setMail("emplyeeTest"+ Math.random()+"@gmail.com");
        employee.setEnabled(true);
        employee.setPhone("+1323953565");

        employee = employeeRepository.saveAndFlush(employee);

        List<Employee> list = employeeRepository.findAll() ;

        Order order = new Order();

        order.setMail("orderTest"+ Math.random()+"@mail.com");
        order.setCompany("Royal");
        order.setFullName("Alex under");
        order.setPhoneNumber("3233233232");

        //order.setAdvertisement(1);
        //order.setSizeOfMove(3);
//        order.setLabor(false);
//        order.setPickUpDate(071220161030L);
//        order.setEstimateDate(071120161030L);
//        order.setPackageDate(071120161030L);
//        order.setTruck(2);
//        order.setMovers(4);
        //order.setServiceCharge(1);
//        order.setOrderDay(061720161215L);
//        order.setStored(false);
//        order.setDiscount(10.0);
        //order.setServiceCharge(1);
        //order.setShrink(5);
        //order.setTape(10);
        //order.setHeavyItem(1);
//        order.setDdt(20);
//        order.setAddExtra(100.00);
//        order.setTotalPricePerFirstHours(570.0);
//        order.setFieldForSalesmanComments("you have to do this because you have to do this");
//        order.setFieldForManagerComments("you have to do this because you have to do it");
//        order.setFollowUpDate(null);
//        order.setStatus(1);
//        order.setBoxDeliveredDate(System.currentTimeMillis());
//        order.setLoadingAddress(addresses);
//        order.setUnloadingAddress(addresses);

        order = orderRepository.save(order);

    }

    private void save(Client client) {
        clientRepository.save(client);
    }
}
