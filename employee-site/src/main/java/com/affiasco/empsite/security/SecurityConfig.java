package com.affiasco.empsite.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    // in memory auth, does not user application.properties information
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}
