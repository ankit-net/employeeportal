package com.ankit.web;

import com.ankit.impl.EmployeeServiceImpl;
import com.ankit.model.EmployeeModel;
import com.ankit.model.EmployeeResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    private Logger logger = LogManager.getLogger(EmployeeController.class);

    @RequestMapping("/list")
    public EmployeeResponse listEmployees() {
        logger.info("Entered EmployeeController");
        List<EmployeeModel> employeesList = null;
        EmployeeResponse employeeResponse = new EmployeeResponse();

        try {
            employeesList = employeeService.listAllEmployees();
            employeeResponse.setEmployees(employeesList);
        }
        catch (Exception ex) {
            employeeResponse.setErrorcode("500");
            employeeResponse.setErrorMessage(ex.getMessage());
        }
        return employeeResponse;
    }
}
