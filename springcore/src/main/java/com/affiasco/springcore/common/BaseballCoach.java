package com.affiasco.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach  implements  Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30minutes in batting practice";
    }
}
