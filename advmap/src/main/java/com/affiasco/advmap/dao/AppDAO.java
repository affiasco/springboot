package com.affiasco.advmap.dao;

import com.affiasco.advmap.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
}
