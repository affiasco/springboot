package com.affiasco.empsite.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) { // datasource injected and autoconfigured by spring
        JdbcUserDetailsManager udm = new JdbcUserDetailsManager(dataSource);

        // ? is param sent by login form
        udm.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        udm.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return udm;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                // gives permissions to view certain routes based on role
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                // this checks that every request coming in must be authenticated
                                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")               // gives the route to login page (set in the controller)
                        .loginProcessingUrl("/authenticateTheUser")  // route for the login form to POST data to (to check un/pw), no controller required
                        .permitAll()                                 // everyone can access the login page even without logging in
                )
                .logout(logout -> logout.permitAll() // sets up /logout route and for everyone to see it
                )
                // when access is denied to a role this is the returned view
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")
                );


        return http.build();
    }

    // in memory auth, does not user application.properties information
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//
//        UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
//        UserDetails mary = User.builder().username("mary").password("{noop}test123").roles("EMPLOYEE", "MANAGER").build();
//        UserDetails susan = User.builder().username("susan").password("{noop}test123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }
}
