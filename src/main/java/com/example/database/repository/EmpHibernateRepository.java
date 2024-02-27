//package com.example.database.repository;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.example.database.entity.Employee;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//
//@Repository
//public class EmpHibernateRepository {
//	
//	@Autowired
//	 private EntityManager entityManager;
//
//
//	    public void addUser(Employee user) {
//	        entityManager.getTransaction().begin();
//	        entityManager.persist(user);
//	        entityManager.getTransaction().commit();
//	    }
//
//	    public List<Employee> getAllUsers() {
//	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//	        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
//	        Root<Employee> root = criteriaQuery.from(Employee.class);
//	        criteriaQuery.select(root);
//	        return entityManager.createQuery(criteriaQuery).getResultList();
//	    }
//
//	    public void deleteUser(int userId) {
//	    	Employee user = entityManager.find(Employee.class, userId);
//	        if (user != null) {
//	            entityManager.getTransaction().begin();
//	            entityManager.remove(user);
//	            entityManager.getTransaction().commit();
//	        }
//	    }
//}
