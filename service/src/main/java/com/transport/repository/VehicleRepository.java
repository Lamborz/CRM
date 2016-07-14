package com.transport.repository;

import com.transport.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

   @Query(nativeQuery = false, value = "select v from Vehicle v right join fetch v.bookedTime b \n" +
           "Where b.vehicle = v.id " +
           "AND (b.startPeriod < :startPeriod OR b.startPeriod > :finishPeriod) " +
           "AND (b.finishPeriod < :startPeriod OR b.finishPeriod > :finishPeriod)")
   Set<Vehicle> findAllByPeriod(@Param("startPeriod") Long startPeriod, @Param("finishPeriod") Long finishPeriod);
}
