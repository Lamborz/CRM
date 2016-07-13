package com.transport.repository;

import com.transport.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created by 1 on 6/10/2016.
 */
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
    //@Query("")
   // List<Employee> findByName(String name);

}
