package com.soumenprogramming.elearning.controller;

import com.soumenprogramming.elearning.dao.Logindetailsservice;
import com.soumenprogramming.elearning.model.Logindetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Logindetailscontroller {

    @Autowired
    private Logindetailsservice logindetailsservice;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Logindetails logindetails) {
        Logindetails existingUser = logindetailsservice.findByUsername(logindetails.getUsername());
        Logindetails existingEmail = logindetailsservice.findByEmail(logindetails.getEmail());

        if (existingUser != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
        } else if (existingEmail != null) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        } else {
            logindetailsservice.save(logindetails);
            return new ResponseEntity<>("Registration Successful", HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Logindetails logindetails) {
        Logindetails existingUser = logindetailsservice.findByUsername(logindetails.getUsername());

        if (existingUser == null) {
            return new ResponseEntity<>("Username is incorrect", HttpStatus.NOT_FOUND);
        }

        if (existingUser.getPassword().equals(logindetails.getPassword())) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Password is incorrect", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<Logindetails> getLogin(@PathVariable int id) {
        Logindetails logindetails = logindetailsservice.findById(id);
        if (logindetails != null) {
            return new ResponseEntity<>(logindetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/logins/{id}")
    public ResponseEntity<Logindetails> updateLogin(@PathVariable int id, @RequestBody Logindetails updatedLogindetails) {
        Logindetails updatedUser = logindetailsservice.update(id, updatedLogindetails);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/logins/{id}")
    public ResponseEntity<String> deleteLogin(@PathVariable int id) {
        boolean isDeleted = logindetailsservice.deleteById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
