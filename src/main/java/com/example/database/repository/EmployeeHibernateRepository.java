package com.example.database.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;


@Repository
public class EmployeeHibernateRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addUser(Employee user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public List<Employee> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        }
    }
    
    public List<Employee> findByName(String firstName) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root)
                         .where(criteriaBuilder.equal(root.get("firstName"), firstName));
            Query<Employee> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public void deleteUser(int userId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Employee user = session.get(Employee.class, userId);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        }
    }

}
