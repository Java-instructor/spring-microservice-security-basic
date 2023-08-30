package com.java.instructor.spring.microservice.departments.service;

import java.util.List;

import com.java.instructor.spring.microservice.departments.entity.Department;

public interface DepartmentService {
	Department saveDepartment(Department department);

	Department getDepartmentById(Long departmentId);

	List<Department> getAllDepartments();
}