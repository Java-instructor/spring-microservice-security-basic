package com.java.instructor.spring.microservice.departments.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.instructor.spring.microservice.departments.entity.Department;
import com.java.instructor.spring.microservice.departments.repository.DepartmentRepository;
import com.java.instructor.spring.microservice.departments.service.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
}