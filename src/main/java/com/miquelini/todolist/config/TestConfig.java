package com.miquelini.todolist.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.miquelini.todolist.entities.Todo;
import com.miquelini.todolist.repositories.TodoRepository;



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {

        Todo t1 = new Todo("Estudar", "Estudar Spring Boot 2 e Spring Cloud", false);

        todoRepository.saveAll(Arrays.asList(t1));

        System.out.println("TestConfig.run()");
    }



}
