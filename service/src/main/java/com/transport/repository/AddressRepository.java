package com.transport.repository;

import com.transport.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1 on 6/6/2016.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
