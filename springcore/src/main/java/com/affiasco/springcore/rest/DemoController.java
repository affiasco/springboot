package com.affiasco.springcore.rest;

import com.affiasco.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

//    Setter Injection
//    @Autowired
//    public void setCoach(@Qualifier("baseballCoach") Coach theCoach) {
//        myCoach = theCoach;
//    }

//  Constructor Injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("swimCoach") Coach theAnotherCoach) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

//  singleton == true, prototype == false
    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return "First workout: " + myCoach.getDailyWorkout() + "; Second workout: " + anotherCoach.getDailyWorkout();
    }
}
