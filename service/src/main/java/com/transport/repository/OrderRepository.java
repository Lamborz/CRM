package com.transport.repository;

import com.transport.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by AK on 6/6/2016.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByOrderDayBetween(Long startDate, Long endDate);
}
