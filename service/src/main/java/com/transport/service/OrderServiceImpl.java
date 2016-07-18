package com.transport.service;


import com.transport.form.OrderForm;
import com.transport.form.PaymentDetailsForm;
import com.transport.model.Address;
import com.transport.model.Client;
import com.transport.model.Order;
import com.transport.repository.AddressRepository;
import com.transport.repository.ClientRepository;
import com.transport.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 6/10/2016.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Order addOrder(OrderForm orderForm, PaymentDetailsForm detailsForm) {

        Address addressFrom = new Address();
        addressFrom.setZip(orderForm.getZipFrom());
        addressFrom.setAddress(orderForm.getLoadingAddress());
       // addressFrom.setFloor(orderForm.getFloor());
        addressFrom = addressRepository.save(addressFrom);

        Address addressTo = new Address();
        addressTo.setAddress(orderForm.getLoadingAddress());
        addressTo.setZip(orderForm.getZipTo());
        //addressTo.setFloor(orderForm.getFloor());

        addressTo = addressRepository.save(addressTo);

        Set<Address> loadingAddress = new HashSet<>();
        Set<Address> unloadingAddress = new HashSet<>();

        loadingAddress.add(addressFrom);
        unloadingAddress.add(addressTo);

        Client client = clientRepository.findByMail(orderForm.getMail());
        if(client == null){
            Client newClient = new Client();
            newClient.setFullName(orderForm.getFullName());
            newClient.setMail(orderForm.getMail());
            newClient.setPhone(orderForm.getPhoneNumber());
            client = clientRepository.save(newClient);
        }


        Order order = new Order();

        order.setDiscount(detailsForm.getDiscount());
        //complete sets

        order.setCompany(orderForm.getCompany());
        order.setFullName(orderForm.getFullName());
        order.setAdvertisement(orderForm.getAdvertisement());

        order.setSizeOfMove(orderForm.getSizeOfMove());
        order.setLabor(orderForm.isLabor());

        order.setLoadingAddress(loadingAddress);
        order.setLoadingAddress(unloadingAddress);

        order.setOrderDay(System.currentTimeMillis());
        order.setClient(client);
      //order.setEstimateDate(orderForm.getEstimateDate());
        //order.setBoxDeliveredDate(orderForm.getBoxDeliveredDate());
       // order.setPackageDate(orderForm.getPackageDate());
        // order.setPickUpDate(orderForm.getPickUpDate());

        //order.setStored(orderForm.isStored());
       // order.setDurationStorage(orderForm.getDurationStorage());

//        order.setTruck(orderForm.getTruck());
//        order.setMovers(orderForm.getMovers());
//        order.setHeavyItem(orderForm.getHeavyItem());
//        order.setServiceCharge(orderForm.getServiceCharge());
//        order.setShrink(orderForm.getShrink());
//        order.setTape(orderForm.getTape());
//        order.setBoxQuantity(orderForm.getBoxQuantity());
//        order.setDdt(orderForm.getDdt());

//        order.setTotalPricePerFirstHours(orderForm.getTotalPricePerFirstHours());
//       order.setRateOrFlat(orderForm.getRateOrFlat());
//        order.setAddExtra(orderForm.getAddExtra());
//        order.setDiscount(orderForm.getDiscount());
//        order.setTotalPricePerFirstHours(orderForm.getTotalPricePerFirstHours());

        order.setMail(orderForm.getMail());

//        order.setFollowUpDate(orderForm.getFollowUpDate());
//        order.setFieldForManagerComments(orderForm.getFieldForManagerComments());
//        order.setFieldForSalesmanComments(orderForm.getFieldForSalesmanComments());

        Order resultOrder = orderRepository.save(order);
        return resultOrder;

    }
}
