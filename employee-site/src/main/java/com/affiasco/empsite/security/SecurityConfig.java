package com.affiasco.empsite.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // this checks that every request coming in must be authenticated
        http.authorizeHttpRequests(configurer ->
                        configurer.anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")              // gives the route to login page (set in the controller)
                        .loginProcessingUrl("/authenticateTheUser") // route for the login form to POST data to (to check un/pw), no controller required
                        .permitAll()                                // everyone can access the login page even without logging in
                );

        return http.build();
    }
}
