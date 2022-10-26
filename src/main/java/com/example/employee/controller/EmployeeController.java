package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get list of all employees
    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // Get employees by id
    @GetMapping("ById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    // Get employee by name
    @GetMapping("ByName/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name){
        return employeeService.getEmployeeByName(name);
    }

    // Get employee by designation
    @GetMapping("ByDesignation/{designation}")
    public List<Employee> getEmployeeByDesignation(@PathVariable("designation") String designation){
        return employeeService.getEmployeeByDesignation(designation);
    }

    // Get employee by department
    @GetMapping("ByDepartment/{Department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable("Department") String department){
        return employeeService.getEmployeeByDepartment(department);
    }

    // Get all Employees with sort by any field in ascending order
    @GetMapping("SortBy={field}")
    public List<Employee> sortEmployeeId(@PathVariable("field") String field){
        return employeeService.sortEmployeeId(field);
    }

    // Get employees with pagesize and offset (Pagination)
    @GetMapping("pageSize={pageSize}&&offset={offset}")
    public Page<Employee> pagination(@PathVariable("pageSize") Integer pageSize, @PathVariable("offset") Integer offset){
        return employeeService.pagination(pageSize, offset);
    }

    // Get count by name
    @GetMapping("countByName/{name}")
    public Integer countByName(@PathVariable("name") String name){
        return employeeService.countByName(name);
    }

    // check if exist by department
    @GetMapping("existByDepartment/{department}")
    public Boolean existsByDepartment(@PathVariable("department") String department){
        return employeeService.existsByDepartment(department);
    }

    // Check if exist by id
    @GetMapping("existById/{id}")
    public Boolean existsById(@PathVariable("id") Integer id){
        return employeeService.existsById(id);
    }

    // FindBy name
    @GetMapping("findBy/{name}")
    public Employee findBy(@PathVariable("name") String name){
        return employeeService.findBy(name);
    }

    // Delete all employees
    @DeleteMapping("deleteAll")
    public String deleteAll(){
        return employeeService.deleteAll();
    }

    // Delete all employees
    @DeleteMapping("flush")
    public void flush(){
        employeeService.flush();
    }


    // Get all employee salary less than given salary JPQL and Native
    @GetMapping("salary<{salary}")
    public List<Employee> getAllEmployeeSalaryLessThan(@PathVariable("salary") Double salary){
        return employeeService.getAllEmployeeSalaryLessThan(salary);
    }

    // Add new employee
    @PostMapping("add")
    public List<Employee> addEmployee(@RequestBody List<Employee> employees){
        return employeeService.addEmployees(employees);
    }

    // Update employee
    @PutMapping("update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }

}
