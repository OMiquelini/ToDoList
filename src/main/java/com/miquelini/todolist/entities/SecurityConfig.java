package com.miquelini.todolist.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SecurityFilterChain;

import com.miquelini.todolist.services.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService; // Assuming you've implemented UserDetailsService

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
           .authorizeHttpRequests(authorize -> authorize
               .antMatchers("/login", "/register").permitAll()
               .anyRequest().authenticated()
           )
           .formLogin(form -> form
               .loginPage("/login")
               .defaultSuccessUrl("/todos"));
           // Adjust for production environment:
           // .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
