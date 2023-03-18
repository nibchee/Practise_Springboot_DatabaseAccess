package com.geekynib.cruddemo.dao;

import com.geekynib.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student  findById(Integer id);
}
