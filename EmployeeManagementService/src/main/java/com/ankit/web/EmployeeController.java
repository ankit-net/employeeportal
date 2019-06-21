package com.ankit.web;

import com.ankit.model.ApiResponse;
import com.ankit.service.EmployeeServiceImpl;
import com.ankit.model.EmployeeModel;
import com.ankit.model.EmployeeResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    private Logger logger = LogManager.getLogger(EmployeeController.class);

    @RequestMapping("/hello")
    public String helloWorld(){
        return "Tekmindz";
    }

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
            employeeResponse.setErrorMessage("Internal Server Error");
            logger.error("Server Error", ex);
        }
        return employeeResponse;
    }

    @PostMapping("/add")
    public ApiResponse addEmployee(@RequestBody EmployeeModel employeeModel){
        ApiResponse apiResponse = new ApiResponse();

        try {
            logger.info("add employee source:{}"+ employeeModel);
            employeeService.addEmployee(employeeModel);
            apiResponse.setStatus(true);
        }
        catch (Exception ex) {
            apiResponse.setErrorcode("500");
            apiResponse.setErrorMessage("Internal Server Error");
            logger.error("Server Error", ex);
        }

        return apiResponse;
    }
}
