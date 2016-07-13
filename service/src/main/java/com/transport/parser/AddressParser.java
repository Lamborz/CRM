package com.transport.parser;

import com.transport.model.Employee;
import com.transport.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Victoria on 6/18/2016.
 */
public class AddressParser {

    @Autowired
    private EmployeeRepository employeeRepository;


//public String parser(String loading, String unloading) {
    //String loading = "1, 691 irolo, 90095;";
    //String unloading = "2, 23 popopo,90065;";

//    String delims = "[,]+";
//
//    String[] arrayLoading = loading.split(delims);
//    String[] arrayUnloading = unloading.split(delims);
//
//
//    AddressParserResult addressParserResult = new AddressParserResult();
//
//    for (String t : arrayLoading) {
//        if (arrayLoading[0] == "1") {
//            addressParserResult.getLoadingAddress().put(Integer.parseInt(arrayLoading[2]), arrayLoading[1]);
//        }
//    }
//    for (String t : arrayUnloading) {
//        if (arrayUnloading[0] == "1") {
//            addressParserResult.getUnLoadingAddress().put(Integer.parseInt(arrayUnloading[2]), arrayUnloading[1]);
//        }
//    }
//
//}
  Employee getEmployee(int id){

      return employeeRepository.getOne(id);
  }

}
