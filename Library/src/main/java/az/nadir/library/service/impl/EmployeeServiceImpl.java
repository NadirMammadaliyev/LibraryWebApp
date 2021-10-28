/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.service.impl;

import az.nadir.library.dao.EmployeeDao;
import az.nadir.library.model.Employee;
import az.nadir.library.service.EmployeeService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author Asus
 */
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeLong) throws Exception {
        return employeeDao.getEmployeeById(employeeLong);
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public List<Employee> searchEmployeeData(String keyWord) throws Exception {
        return employeeDao.searchEmployeeData(keyWord);
    }

}
