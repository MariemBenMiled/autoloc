package org.example.autoloc.service;

import org.example.autoloc.entities.Employee;
import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
}