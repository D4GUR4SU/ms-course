package com.spring.hruser.resources;

import com.spring.hruser.entities.User;
import com.spring.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = repository.findById(id).get();
        return ResponseEntity.ok(user);
    }

@GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = repository.findByEmail(email);
        return ResponseEntity.ok(user);
    }


}
