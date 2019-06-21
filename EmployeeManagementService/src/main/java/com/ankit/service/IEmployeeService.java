package com.ankit.service;

import com.ankit.entity.Employee;
import com.ankit.model.ApiResponse;
import com.ankit.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {

    public List<EmployeeModel> listAllEmployees() throws Exception;

    public void addEmployee(EmployeeModel employee) throws Exception;
}
