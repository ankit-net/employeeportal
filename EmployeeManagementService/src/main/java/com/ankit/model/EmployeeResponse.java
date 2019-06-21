package com.ankit.model;

import java.util.List;

public class EmployeeResponse extends ApiResponse{

    private List<EmployeeModel> employees;

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
    }
}
