package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
    List<Employee> findByDesignation(String name);
    List<Employee> findByDepartment(String department);

    @Query(value = "select * from Employee where salary < :salary", nativeQuery = true)
    List<Employee> getAllEmployeeSalaryLessThan(@Param("salary") Double salary);

    Integer countByName(String name);

    Boolean existsByDepartment(String department);
}
