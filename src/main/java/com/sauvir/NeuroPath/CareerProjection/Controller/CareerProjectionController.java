package com.sauvir.NeuroPath.CareerProjection.Controller;

import com.sauvir.NeuroPath.CareerProjection.Model.CareerProjection;
import com.sauvir.NeuroPath.CareerProjection.Service.CareerProjectionService;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import com.sauvir.NeuroPath.UserProfile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CareerProjectionController {

    @Autowired
    private CareerProjectionService serviceCareerProjection;

    @Autowired
    private UsersService serviceUsers;

    @GetMapping("/projections/{userId}")
    public ResponseEntity<List<CareerProjection>> getProjectionsByUser(@PathVariable int userId, Neo4jProperties.Authentication authentication){
        String loggedInUserName= authentication.getUsername();
        if(serviceUsers.findUserName(userId)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(serviceCareerProjection.getProjectionForUser(userId), HttpStatus.OK);
    }

    @PostMapping("/projections")
    public ResponseEntity<CareerProjection> addProjection(@RequestBody CareerProjection careerProjection){
        return new ResponseEntity<>(serviceCareerProjection.saveProjection(careerProjection),HttpStatus.OK);
    }
}
