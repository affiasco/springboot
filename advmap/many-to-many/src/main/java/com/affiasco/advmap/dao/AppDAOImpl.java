package com.affiasco.advmap.dao;

import com.affiasco.advmap.entity.Course;
import com.affiasco.advmap.entity.Instructor;
import com.affiasco.advmap.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor); // because of CascadeType.ALL will also save instructor_details objects
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId); // will also get instructor_details bc default OneToOne fetch type is eager
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor ti = findInstructorById(theId);

        List<Course> courses = ti.getCourses();

        for (Course course : courses) {
            course.setInstructor(null); // remove instructor from those courses and prevents a constraint violation
        }

        entityManager.remove(ti); // CascadeType.ALL will also delete the instructor_Detail
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId); // will also get instructor bc default OneToOne fetch type is eager
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tid = findInstructorDetailById(theId);

        // remove assocaited object ref to break bi-directional link
        tid.getInstructor().setInstructorDetail(null);

        entityManager.remove(tid);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses " // lazy loads but feels like eager loading
                        + "JOIN FETCH i.instructorDetail " // gets the instructor detail with the 1 query
                        + "where i.id = :data", Instructor.class);

        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course theCourse) {
        entityManager.merge(theCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tc = findCourseById(theId);
        entityManager.remove(tc);
    }

    @Override
    @Transactional
    public void saveCourse(Course theCourse) {
        entityManager.persist(theCourse); // cascade all will save the course and associated reviews
    }

    @Override
    public Course findCourseAndReviewsbyId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.reviews "
                        + "WHERE c.id = :data", Course.class);

        query.setParameter("data", theId);
        return query.getSingleResult();
    }
}
