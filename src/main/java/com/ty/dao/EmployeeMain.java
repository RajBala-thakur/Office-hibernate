package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Employee;
import com.ty.dto.Office;

public class EmployeeMain {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Employee e1 = new Employee();
		e1.setName("Pinki");
		e1.setAge(23);
		e1.setDept("Development");

		Employee e2 = new Employee();
		e2.setName("Jyoti");
		e2.setAge(23);
		e2.setDept("Testing");

		Office office = new Office();
		office.setName("Infosys");
		office.setLoc("Btm");
		office.setField("Software");

		e1.setOffice(office);
		e2.setOffice(office);
		List<Employee> ls = new ArrayList<Employee>();
		ls.add(e1);
		ls.add(e2);

		office.setEmployee(ls);

		entityTransaction.begin();
		entityManager.persist(e1);
		entityManager.persist(e2);
		entityManager.persist(office);
		entityTransaction.commit();
	}

}
