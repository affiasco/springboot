package com.affiasco.crudjpa;

import com.affiasco.crudjpa.dao.StudentDAO;
import com.affiasco.crudjpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudjpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;

        Student theStudent = studentDAO.findById(studentId);
        System.out.println("Getting student with id " + studentId);

        System.out.println("Updating the first name");
        theStudent.setFirstName("Jeff");

        studentDAO.update(theStudent);
        System.out.println("Updated Student " + theStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Ripper");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating student...");
        Student tempStudent = new Student("Daffy", "Duck", "duck@daffy.com");

        System.out.println("Saving student...");
        studentDAO.save(tempStudent);

        int id = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + id);


        System.out.println("Retrieving student...");
        Student myStudent = studentDAO.findById(id);

        System.out.println("Retrieved student: " + myStudent);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating multiple student objects...");

        Student tempStudent1 = new Student("Jeff", "Johnson", "jeff@gmail.com");
        Student tempStudent2 = new Student("Rupert", "Ripper", "rups@gmail.com");
        Student tempStudent3 = new Student("Sandy", "Smith", "sandy@gmail.com");

        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        System.out.println("Saved student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student. Generated id: " + tempStudent3.getId());
    }

}
