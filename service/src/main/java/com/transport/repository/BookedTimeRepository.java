package com.transport.repository;

import com.transport.model.BookedTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Maksim Zagorodskiy on 7/15/2016.
 */
public interface BookedTimeRepository extends JpaRepository<BookedTime, Integer> {
    @Query("from BookedTime bt WHERE bt.vehicle = :id AND bt.startPeriod BETWEEN :startPeriod AND :endPeriod ORDER BY bt.startPeriod")
    List<BookedTime> findByVehicleIdAndDateBetween(@Param("id")Integer id, @Param("startPeriod") Long startPeriod,
                                                   @Param("endPeriod") Long finishDate);
}
