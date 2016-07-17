package com.transport.repository;

import com.transport.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maksim Zagorodskiy on 7/10/2016.
 */
public interface TariffRepository extends JpaRepository<Tariff, Integer> {

    Tariff findByCompanyAndTariffType(String company, Integer tariffType);

}
