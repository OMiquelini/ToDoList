package com.miquelini.todolist.resources;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miquelini.todolist.entities.Todo;
import com.miquelini.todolist.services.TodoService;



@RestController
public class TodoResource {
    
    private final TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @PostMapping
    public Todo addTodo(Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo update(Todo todo) {
        return todoService.update(todo);
    }

    @GetMapping("/{id}")
    public Todo getTodoById(Long id) {
        return todoService.getTodoById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        todoService.delete(id);
    }
        
}
