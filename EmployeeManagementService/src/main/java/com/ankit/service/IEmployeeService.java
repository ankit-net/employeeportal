package com.ankit.service;

import com.ankit.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {

    public List<EmployeeModel> listAllEmployees() throws Exception;
}
