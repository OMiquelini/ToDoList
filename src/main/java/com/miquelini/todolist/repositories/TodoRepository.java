package com.miquelini.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miquelini.todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
