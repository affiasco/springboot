package com.affiasco.springcore.common;

//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
public class BaseballCoach  implements  Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30minutes in batting practice";
    }
}
