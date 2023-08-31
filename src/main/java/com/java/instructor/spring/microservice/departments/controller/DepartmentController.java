package com.java.instructor.spring.microservice.departments.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.instructor.spring.microservice.departments.entity.Department;
import com.java.instructor.spring.microservice.departments.service.DepartmentService;

import lombok.AllArgsConstructor;


/**
 * @author Java-Instructor
 *
 */
@RestController
@RequestMapping("departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity(savedDepartment, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
		Department department = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(department);
	}

	@GetMapping("/all")
	//@PreAuthorize("hasAuthority('ROLE_INSTRUCTOR')") // method level security 
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}
	@GetMapping("/test")
	public ResponseEntity<String> getTest() {
	
		return ResponseEntity.ok("Hello test ");
	}
}