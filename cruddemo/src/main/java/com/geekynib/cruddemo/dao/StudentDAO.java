package com.geekynib.cruddemo.dao;

import com.geekynib.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student  findById(Integer id);

    List<Student> findAll();
}
