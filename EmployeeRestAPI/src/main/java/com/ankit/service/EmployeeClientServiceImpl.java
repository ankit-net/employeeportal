package com.ankit.service;

import com.ankit.model.EmployeeResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeClientServiceImpl implements EmployeeClientInterface {

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = Logger.getLogger(EmployeeClientServiceImpl.class);

    @Override
    public EmployeeResponse employeesListService() {
        logger.info("Entered EmployeeService");
        EmployeeResponse employeeResponse = new EmployeeResponse();
        ResponseEntity<EmployeeResponse> employeeClientResponse = null;

        try {
            employeeClientResponse = restTemplate.getForEntity("http://localhost:10090/servicing/employees/list", EmployeeResponse.class);

            if(employeeClientResponse != null) {
                employeeResponse = employeeClientResponse.getBody();
                logger.info("Response from Employee Service=>"+employeeResponse);
                return  employeeResponse;
            }
            else {
                employeeResponse.setStatus(false);
                employeeResponse.setErrorMessage("INVALID EMPLOYEE SERVICE RESPONSE");
            }
        }
        catch (Exception ex) {
            employeeResponse.setStatus(false);
            employeeResponse.setErrorMessage("SERVER ERROR");
        }


        return employeeResponse;
    }
}
