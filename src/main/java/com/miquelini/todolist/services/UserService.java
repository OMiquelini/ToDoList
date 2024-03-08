package com.miquelini.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.miquelini.todolist.entities.User;
import com.miquelini.todolist.entities.UserPrincipal;
import com.miquelini.todolist.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> obj = repository.findById(id); 
        return obj.get();
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }   

}
