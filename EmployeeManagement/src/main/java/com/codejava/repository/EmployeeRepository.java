package com.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejava.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
