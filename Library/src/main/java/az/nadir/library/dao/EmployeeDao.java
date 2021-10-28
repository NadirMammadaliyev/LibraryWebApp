/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao;

import az.nadir.library.model.Employee;

import java.util.List;

/**
 * @author Asus
 */
public interface EmployeeDao {

    List<Employee> getEmployeeList() throws Exception;

    void addEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(Long employeeLong) throws Exception;

    void updateEmployee(Employee employee) throws Exception;

    void deleteEmployee(Long employeeId) throws Exception;

    List<Employee> searchEmployeeData(String keyWord) throws Exception;
}
