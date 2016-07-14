package com.transport.repository;

import com.transport.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maksim Zagorodskiy on 7/13/2016.
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
//
//   @Query("select v from vehicle_entity v join v.bookingTime b where b.startPeriod > :startPeriod and b.endPeriod < endPeriod")
//    List<Vehicle> findAllByPeriod(@Param("startPeriod") int startPeriod, @Param("endPeriod") int endPeriod);

}
