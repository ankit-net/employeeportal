package com.ankit.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private int empid;

    private String firstname;

    private String lastname;

    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "stateid", referencedColumnName = "id")
    private State stateid;

    @ManyToOne
    @JoinColumn(name = "countryid", referencedColumnName = "id")
    private Country countryid;

    @ManyToOne
    @JoinColumn(name = "cityid", referencedColumnName = "id")
    private City cityid;

    @ManyToOne
    @JoinColumn(name = "departmentid", referencedColumnName = "id")
    private Department departmentid;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee managerid;

    private boolean active;

    private Timestamp createddate;

    private int createdby;

    private Timestamp updatedate;

    private int updatedby;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public State getStateid() {
        return stateid;
    }

    public void setStateid(State stateid) {
        this.stateid = stateid;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    public City getCityid() {
        return cityid;
    }

    public void setCityid(City cityid) {
        this.cityid = cityid;
    }

    public Department getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    public Employee getManagerid() {
        return managerid;
    }

    public void setManagerid(Employee managerid) {
        this.managerid = managerid;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    public int getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(int updatedby) {
        this.updatedby = updatedby;
    }
}
