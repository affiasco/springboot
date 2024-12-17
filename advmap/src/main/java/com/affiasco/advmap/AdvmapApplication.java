package com.affiasco.advmap;

import com.affiasco.advmap.dao.AppDAO;
import com.affiasco.advmap.entity.Instructor;
import com.affiasco.advmap.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            findInstructor(appDAO);
        };
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

}
