package com.sauvir.NeuroPath.UserProfile.controller;

import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UsersController {

    @Autowired
    private UsersService serviceuser;



    @PostMapping("/users")
    public ResponseEntity<Users> addUser(@RequestBody Users users){
        return new ResponseEntity<>(serviceuser.saveUser(users), HttpStatus.OK);
    }

    @GetMapping("/userss/{id}")
    public ResponseEntity<Users> getUsersbyId(@PathVariable int id){
        return new ResponseEntity<>(serviceuser.getUsersById(id),HttpStatus.OK);
    }

    @PutMapping("/userss/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable int id , @RequestBody Users updatedusers, Neo4jProperties.Authentication authentication){
        String loggedInUserName= authentication.getUsername();
        if(serviceuser.findUserName(id)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(serviceuser.updateUsers(id,updatedusers),HttpStatus.OK);
    }

    @DeleteMapping("/userss/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable int id, Neo4jProperties.Authentication authentication){
        String loggedInUserName= authentication.getUsername();
        if(serviceuser.findUserName(id)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        serviceuser.deleteUsers(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
