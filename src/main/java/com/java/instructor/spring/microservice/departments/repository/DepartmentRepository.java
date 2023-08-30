package com.java.instructor.spring.microservice.departments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.instructor.spring.microservice.departments.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}