package com.cap.dao;

import java.util.List;
import java.util.Optional;

import com.cap.entity.Employee;

public interface EmployeeDao {
	public String createAccount(Object emp) ;

	public Employee findById(int id);

	public String deleteById(int id);

	public List fetchAll();

	public String updateEmp(Employee emp);



	

}
