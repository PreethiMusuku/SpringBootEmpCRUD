package com.cap.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.cap.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;
	@Transactional
		public String createAccount(Employee emp) {
			em.merge(emp);
			return "Account Created";
		}
	@Override
	@Transactional
	public Employee findById(int eid) {
		Employee emp= em.find(Employee.class, eid);
		return emp;
	}
	
	
	@Override
	@Transactional
	public List fetchAll() {
		Query q=em.createQuery("select emp from Employee emp");
		List list=(List) q.getResultList();
		return  list;
	}
	@Override
	@Transactional
	public String updateEmp(Employee emp) {
		Employee e=em.find(Employee.class, emp.getEid());
		e.setEname(emp.getEname());
		e.setEsal(emp.getEsal());
		em.merge(e);
		if(e==null) {
			return "no updates found";
		}
		return "updated succesfully";
	}
	@Override
	public String deleteById(int eid) {
		// TODO Auto-generated method stub
		Employee emp=em.find(Employee.class, eid);
		em.remove(emp);
		if(emp!=null)
		{
			return "deleted successfully";
		}
		return "not found";
	}
}