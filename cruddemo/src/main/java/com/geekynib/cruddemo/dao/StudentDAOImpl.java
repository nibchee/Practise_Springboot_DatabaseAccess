package com.geekynib.cruddemo.dao;

import com.geekynib.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//giving support for component scanning i.e creating Bean itself on autowiring & transaltes JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field  for entity manager
    private EntityManager entityManager;

    //inject the entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implemnt the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
      entityManager.persist(theStudent);
    }
}




