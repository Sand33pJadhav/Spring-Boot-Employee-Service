package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> getEmployeeByDesignation(String name) {
        return employeeRepository.findByDesignation(name);
    }

    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setDesignation(employee.getDesignation());
        existingEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee with id " + id + " is deleted";
    }

    public List<Employee> sortEmployeeId(String field) {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Employee> pagination(Integer pageSize, Integer offset) {
        return employeeRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public List<Employee> getAllEmployeeSalaryLessThan(Double salary) {
        return employeeRepository.getAllEmployeeSalaryLessThan(salary);
    }

    public Integer countByName(String name) {
        return employeeRepository.countByName(name);
    }

    public Boolean existsByDepartment(String department) {
        return employeeRepository.existsByDepartment(department);
    }

    public Employee getOne(Integer id) {
        return employeeRepository.getOne(id);
    }

    public Employee findBy(String name) {
        return employeeRepository.findByName(name);
    }

    public Boolean existsById(Integer id) {
        return employeeRepository.existsById(id);
    }

    public String deleteAll() {
        employeeRepository.deleteAll();
        return "Deleted all employees";
    }

    public void flush() {
        employeeRepository.flush();
    }
}
