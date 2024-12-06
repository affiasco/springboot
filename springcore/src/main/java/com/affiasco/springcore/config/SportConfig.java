package com.affiasco.springcore.config;

import com.affiasco.springcore.common.Coach;
import com.affiasco.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
//    @Bean("aquatic") can add a custom beanId
    public Coach swimCoach() { // beanId = swimCoach
        return new SwimCoach();
    }
}
