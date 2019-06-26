package com.ankit.web;

import com.ankit.model.ApiResponse;
import com.ankit.model.EmployeeResponse;
import com.ankit.service.EmployeeClientInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class EmployeeClientController {

    @Autowired
    private EmployeeClientInterface employeeClientInterface;

    private Logger logger = Logger.getLogger(EmployeeClientController.class);

    @RequestMapping("/employee/list")
    public EmployeeResponse getEmployeesList(){
        logger.info("Entered EmployeeClientController");
        EmployeeResponse employeeResponse = employeeClientInterface.employeesListService();

        logger.info("Exit EmployeeClientController");
        return employeeResponse;
    }

    @GetMapping("/hello")
    public ApiResponse helloMessage(){
        return new ApiResponse();
    }

}
