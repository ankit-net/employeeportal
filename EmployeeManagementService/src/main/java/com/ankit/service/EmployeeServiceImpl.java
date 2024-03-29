package com.ankit.service;

import com.ankit.dao.EmployeeDAO;
import com.ankit.entity.Employee;
import com.ankit.model.ApiResponse;
import com.ankit.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<EmployeeModel> listAllEmployees() throws Exception{

        //List<Employ>
        List<Employee> allEmployees = null;
        List<EmployeeModel> allEmployeesModel = null;

        allEmployees = employeeDAO.listAllEmployee();

        if(allEmployees != null && allEmployees.size() > 0){
            allEmployeesModel = new ArrayList<EmployeeModel>();

            for(Employee employee : allEmployees){
                EmployeeModel modal = new EmployeeModel();

                modal.setEmpid(employee.getEmpid());
                modal.setFirstname(employee.getFirstname());
                modal.setLastname(employee.getLastname());
                modal.setActive(employee.isActive());
                modal.setAddress(employee.getAddress());
                modal.setEmail(employee.getEmail());

                allEmployeesModel.add(modal);
            }
        }


        return allEmployeesModel;
    }

    @Override
    public void addEmployee(EmployeeModel employee) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        Employee employeeEntity = new Employee();
        if(employee != null){
            employeeEntity.setEmpid(employee.getEmpid());
            employeeEntity.setActive(true);
            employeeEntity.setFirstname(employee.getFirstname());
            employeeEntity.setLastname(employee.getLastname());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setAddress(employee.getAddress());
            employeeEntity.setCreateddate(new Timestamp(System.currentTimeMillis()));
            employeeEntity.setUpdateddate(new Timestamp(System.currentTimeMillis()));

            if(employee.getManagerid() > 0){
                Employee manager = new Employee();
                manager.setEmpid(employee.getManagerid());
                employeeEntity.setManagerid(manager);
            }



            employeeDAO.addEmployee(employeeEntity);
        }


    }
}
