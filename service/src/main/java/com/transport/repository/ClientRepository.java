package com.transport.repository;

import com.transport.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1 on 6/13/2016.
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByMail(String mail);
    
}
