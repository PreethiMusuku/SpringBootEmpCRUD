package com.cap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.entity.Employee;
import com.cap.service.EmployeeService;

@RestController
@RequestMapping("/Emp")
@CrossOrigin("http://localhost:9098")//
public class RestControllerEmp{

	@Autowired
	private EmployeeService empService;
	@PostMapping("/CreateAccount")
	public String createAccount(@RequestBody Employee emp) {
		return empService.createEmployee(emp);
	}
	@GetMapping("/findById/{empId}")
	public Optional<Employee> findEmployee(@PathVariable Integer empId) {
		return empService.findEmployee(empId);
	}
	@GetMapping("/findAll")
	public List<Employee> findAllEmployees() {
		return empService.findAllEmployees();
	}
	@GetMapping(path="/findByName/{empName}")
	public List<Employee> findEmployeeByName(@PathVariable String empName) {
		return empService.findEmpByName(empName);
	}
	@PutMapping("/updateEmp")
	public String updateEmp(@RequestBody Employee emp) {
		return empService.updateEmployee(emp);
	}
	@DeleteMapping("/deleteEmp/{empId}")
	public String deleteEmp(@PathVariable Integer empId) {
		return empService.deleteEmpById(empId);
	}
}


