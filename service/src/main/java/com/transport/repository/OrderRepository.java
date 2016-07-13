package com.transport.repository;

import com.transport.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by AK on 6/6/2016.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
