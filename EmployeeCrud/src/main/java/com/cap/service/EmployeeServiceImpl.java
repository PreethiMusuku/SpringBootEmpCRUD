package com.cap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dao.EmployeeDao;
import com.cap.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao;
	@Override
		public String createAccount(Employee emp) {
			return	dao.createAccount(emp);
			 
		}
		@Override
		public Employee findById(int id) {
			
			return dao.findById(id);
			
		
		}
		@Override
		public String deleteById(int id) {
			// TODO Auto-generated method stub
			return dao.deleteById(id);
		}
		@Override
		public List fetchAll() {
			// TODO Auto-generated method stub
			return dao.fetchAll();
		}
		@Override
		public String updateEmp(Employee emp) {
			// TODO Auto-generated method stub
			return dao.updateEmp(emp);
		}

	}
	
		
