/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.nadir.library.dao.impl;

import az.nadir.library.dao.DBHelper;
import az.nadir.library.dao.EmployeeDao;
import az.nadir.library.model.Employee;
import az.nadir.library.model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT E.ID,E.NAME EMPLOYEE_NAME, E.SURNAME EMPLOYEE_SURNAME,P.ID POSITION_ID,P.NAME POSITION_NAME FROM EMPLOYEE E\n"
                + "INNER JOIN POSITION P\n"
                + "ON E.POSITION_ID = P.ID\n"
                + "WHERE E.ACTIVE =1 ORDER BY ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql);) {
            if (c != null) {

                while (rs.next()) {
                    Employee employee = new Employee();

                    Position position = new Position();
                    position.setId(rs.getLong("POSITION_ID"));
                    position.setName(rs.getString("POSITION_NAME"));

                    employee.setId(rs.getLong("ID"));
                    employee.setName(rs.getString("EMPLOYEE_NAME"));
                    employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                    employee.setPosition(position);

                    employeeList.add(employee);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        String sql = "INSERT INTO EMPLOYEE\n"
                + "VALUES(EMPLOYEE_SEQ.NEXTVAL,?,?,?,SYSDATE,1)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setLong(3, employee.getPosition().getId());

            ps.execute();
            c.commit();
        }
    }

    @Override
    public Employee getEmployeeById(Long employeeLong) throws Exception {
        Employee employee = new Employee();
        String sql = "SELECT E.ID,E.NAME EMPLOYEE_NAME, E.SURNAME EMPLOYEE_SURNAME,P.ID POSITION_ID,P.NAME POSITION_NAME FROM EMPLOYEE E\n"
                + "INNER JOIN POSITION P\n"
                + "ON E.POSITION_ID = P.ID\n"
                + "WHERE E.ACTIVE =1 AND E.ID=?";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, employeeLong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Position position = new Position();
                position.setId(rs.getLong("POSITION_ID"));
                position.setName(rs.getString("POSITION_NAME"));
                employee.getId();
                employee.setId(rs.getLong("ID"));
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                employee.setPosition(position);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {

        String sql = "UPDATE EMPLOYEE SET NAME =? , SURNAME = ? ,POSITION_ID = ? WHERE ID =? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setLong(3, employee.getPosition().getId());
            ps.setLong(4, employee.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {
        String sql = "UPDATE EMPLOYEE SET ACTIVE = 0 \n"
                + "WHERE ID =?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, employeeId);
            ps.execute();
            c.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchEmployeeData(String keyWord) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        ResultSet rs = null;
        String sql = " SELECT E.ID,\n"
                + "         E.NAME,\n"
                + "         E.SURNAME,\n"
                + "         P.NAME POSITION_NAME\n"
                + "    FROM EMPLOYEE E INNER JOIN POSITION P ON POSITION_ID = P.ID\n"
                + "   WHERE     E.ACTIVE = 1\n"
                + "         AND (   LOWER (E.NAME) LIKE LOWER (?)\n"
                + "              OR LOWER (E.SURNAME) LIKE LOWER (?)\n"
                + "              OR LOWER (P.NAME) LIKE LOWER (?))\n"
                + "ORDER BY E.ID";

        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyWord + "%");
            ps.setString(2, "%" + keyWord + "%");
            ps.setString(3, "%" + keyWord + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();

                Position position = new Position();
                position.setName(rs.getString("POSITION_NAME"));
                employee.setId(rs.getLong("ID"));
                employee.setName(rs.getString("NAME"));
                employee.setSurname(rs.getString("SURNAME"));
                employee.setPosition(position);

                employeeList.add(employee);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employeeList;
    }

}
