package com.ankit.dao;

import com.ankit.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> listAllEmployee() throws Exception{
        String hql = "FROM Employee";
        return (List<Employee>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Employee findEmployee(Employee employee) {
        return entityManager.find(Employee.class, employee.getEmail());
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public boolean employeeExists(Employee employee) {
        String hql = "FROM Employee em WHERE em.email=?";
        int count = entityManager.createQuery(hql).setParameter(1, employee.getEmail()).getMaxResults();
        return count > 0 ? true : false;
    }
}
