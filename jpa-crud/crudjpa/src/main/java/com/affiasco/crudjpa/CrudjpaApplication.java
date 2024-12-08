package com.affiasco.crudjpa;

import com.affiasco.crudjpa.dao.StudentDAO;
import com.affiasco.crudjpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudjpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
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
