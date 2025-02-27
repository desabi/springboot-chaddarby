package com.desabisc.udemy.chad.jpa.dao;

import com.desabisc.udemy.chad.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

  private final EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student student) {
    entityManager.persist(student);
  }

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    // Create the query: field names bases on java class and his properties.
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
    // Return the query results.
    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastName(String theLastName) {
    // create the query
    TypedQuery<Student> query = entityManager.createQuery(
        "FROM Student where lastName=:theData", Student.class);

    // set the query parameters
    query.setParameter("theData", theLastName);

    return query.getResultList();
  }
}
