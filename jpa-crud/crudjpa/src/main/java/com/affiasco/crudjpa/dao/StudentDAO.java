package com.affiasco.crudjpa.dao;

import com.affiasco.crudjpa.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);
}
