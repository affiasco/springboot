package com.affiasco.advmap;

import com.affiasco.advmap.dao.AppDAO;
import com.affiasco.advmap.entity.Course;
import com.affiasco.advmap.entity.Instructor;
import com.affiasco.advmap.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvmapApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr(AppDAO appDAO) {

        return runner -> {
            System.out.println("Hello from runner");
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);

//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);

//            createInstructorWithCourses(appDAO);
//            findInstructorWithCourses(appDAO);
            findCoursesForInstructor(appDAO);
        };
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor ti = appDAO.findInstructorById(theId);
        System.out.println("Temp Instructor: " + ti);

        System.out.println("Finding courses");

        // retrieve and then set courses
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);
        ti.setCourses(courses);

        System.out.println("associated courses: " + ti.getCourses());
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor ti = appDAO.findInstructorById(theId);
        System.out.println("Temp Instructor: " + ti);
        System.out.println("courses: " + ti.getCourses());

        System.out.println("done");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor ti = new Instructor("Rupert", "Schwarm", "schwarm@gmail.com");
        InstructorDetail tid = new InstructorDetail("http://www.youtube.com/rs", "gaming");

        ti.setInstructorDetail(tid); // associates the objects

        // create courses
        Course tempCourse1 = new Course("Air Guitar");
        Course tempCourse2 = new Course("Pinball Masterclass");

        ti.add(tempCourse1);
        ti.add(tempCourse2);

        System.out.println("Adding temp course: " + tempCourse1);
        System.out.println("Adding temp course: " + tempCourse2);

        System.out.println("Saving instructor: " + ti);
        appDAO.save(ti); // also saves the courses because of CascadeType.PERSIST

        System.out.println("Instructor Saved");

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;

        System.out.println("Deleting Instructor Detail, id: " + theId);

        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Delete complete");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 2;

        System.out.println("Finding instructorDetail with id: " + theId);
        InstructorDetail tid = appDAO.findInstructorDetailById(theId);

        System.out.println("ti: " + tid);
        System.out.println("associated instructor: " + tid.getInstructor());
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding instructor with id: " + theId);

        Instructor ti = appDAO.findInstructorById(theId);
        System.out.println("ti: " + ti);
        System.out.println("associated instructor details: " + ti.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor ti = new Instructor("Rupert", "Schwarm", "schwarm@gmail.com");
        InstructorDetail tid = new InstructorDetail("http://www.youtube.com/rs", "gaming");

        ti.setInstructorDetail(tid); // associates the objects

        System.out.println("Saving instructor: " + ti);
        appDAO.save(ti); // also saves the details object because of CascadeType.ALL

        System.out.println("Instructor Saved");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting Instructor, id: " + theId);

        appDAO.deleteInstructorById(theId);
        System.out.println("Delete complete");
    }
}
