package com.miquelini.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miquelini.todolist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}
