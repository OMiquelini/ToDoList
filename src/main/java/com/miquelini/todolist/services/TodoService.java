package com.miquelini.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miquelini.todolist.entities.Todo;
import com.miquelini.todolist.repositories.TodoRepository;


@Service
public class TodoService {
    
    @Autowired
    private TodoRepository repository;
    
    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo getTodoById(Long id) {
        Optional<Todo> obj = repository.findById(id); 
        return obj.get();
    }

    public Todo addTodo(Todo todo) {
        return repository.save(todo);
    }

    public Todo update(Todo todo) {
        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }   

}
