package com.cap.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cap.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	private EntityManager em;
	@Transactional
		public String createAccount(Object emp) {
			em.merge(emp);
			return "Account Created";
		}
	@Override
	@Transactional
	public Employee findById(int id) {
		Employee emp= em.find(Employee.class, id);
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
		Employee e=em.find(Employee.class, emp.getId());
		e.setName(emp.getName());
		e.setSal(emp.getSal());
		em.merge(e);
		if(e==null) {
			return "no updates found";
		}
		return "updated succesfully";
	}
	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		Employee emp=em.find(Employee.class, id);
		em.remove(emp);
		if(emp!=null)
		{
			return "deleted successfully";
		}
		return "not found";
	}
}