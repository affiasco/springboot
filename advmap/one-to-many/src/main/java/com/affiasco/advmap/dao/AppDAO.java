package com.affiasco.advmap.dao;

import com.affiasco.advmap.entity.Instructor;
import com.affiasco.advmap.entity.InstructorDetail;
import com.affiasco.advmap.entity.Course;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void updateInstructor(Instructor theInstructor);

    void updateCourse(Course theCourse);

    Course findCourseById(int theId);
}
