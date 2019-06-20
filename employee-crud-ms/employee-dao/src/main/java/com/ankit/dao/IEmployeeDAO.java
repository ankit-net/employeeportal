package com.ankit.dao;

import com.ankit.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    List<Employee> listAllEmployee() throws Exception;

    Employee findEmployee(Employee employee);

    void addEmployee(Employee employee);

    boolean employeeExists(Employee employee);
}
