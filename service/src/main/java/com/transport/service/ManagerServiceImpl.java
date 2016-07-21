package com.transport.service;

import com.transport.dto.ManagerDTO;
import com.transport.model.Address;
import com.transport.model.Order;
import com.transport.repository.OrderRepository;
import com.transport.util.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AK on 7/19/2016.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<ManagerDTO> getAllManagerDTO() {
        return null;
    }

    @Override
    public List<ManagerDTO> getAllManagerDTOByDate(Long date) {
        List<Order> orders = orderRepository.findByOrderDayBetween(TimeUtil.getStartOfTheDay(date), TimeUtil.getEndOfTheDay(date));
        List<ManagerDTO> managerDTOs = new ArrayList<>();
        for (Order order : orders) {
            ManagerDTO managerDTO = new ManagerDTO();
            managerDTO.setOrderNumber(order.getOrderNumber());
            managerDTO.setOrderDay(order.getOrderDay());

            managerDTO.setFullName(order.getFullName());
            managerDTO.setPhoneNumber(order.getPhoneNumber());
            managerDTO.setMail(order.getMail());

            managerDTO.setFieldForManagerComments(order.getFieldForManagerComments());
            //TODO  пока что только для одного адреса, потом добавить для списка адресов!
            List<Address> loadingAddresses = new ArrayList<>(order.getLoadingAddress());
            managerDTO.setLoadingAddress(loadingAddresses.get(0).getAddress());
            managerDTO.setZipFrom(loadingAddresses.get(0).getZip());

            //TODO  пока что только для одного адреса, потом добавить для списка адресов!
            List<Address> unloadingAddresses = new ArrayList<>(order.getLoadingAddress());

            managerDTO.setUnloadingAddress(unloadingAddresses.get(0).getAddress());
            managerDTO.setZipTo(unloadingAddresses.get(0).getZip());
            managerDTOs.add(managerDTO);
        }
        return managerDTOs;
    }
}
