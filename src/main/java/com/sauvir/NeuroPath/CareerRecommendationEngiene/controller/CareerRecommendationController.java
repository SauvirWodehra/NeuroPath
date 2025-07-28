package com.sauvir.NeuroPath.CareerRecommendationEngiene.controller;

import com.sauvir.NeuroPath.CareerRecommendationEngiene.model.Recommendation;
import com.sauvir.NeuroPath.CareerRecommendationEngiene.service.RecommendationService;
import com.sauvir.NeuroPath.Exceptions.WrongId;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import com.sauvir.NeuroPath.UserProfile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CareerRecommendationController {

    @Autowired
    private RecommendationService serviceRecommendation;

    @Autowired
    private UsersRepository repoUsers;

    @Autowired
    private UsersService serviceUsers;

    @GetMapping("/recommendations/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendationByUser(@PathVariable int userId, Neo4jProperties.Authentication authentication){
        Optional<Users> optionalUsers=repoUsers.findById(userId);
        if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with UserId :"+" "+userId);
        String loggedInUserName= authentication.getUsername();
        if(serviceUsers.findUserName(userId)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(serviceRecommendation.getRecommendationsForUser(userId), HttpStatus.OK);
    }

    @PostMapping("/recommendations/{userId}")
    public ResponseEntity<Recommendation> addRecommendation(@PathVariable int userId, @RequestBody Recommendation recommendation, Neo4jProperties.Authentication authentication){
        Optional<Users> optionalUsers=repoUsers.findById(userId);
        if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with UserId :"+" "+userId);
        String loggedInUserName= authentication.getUsername();
        if(serviceUsers.findUserName(userId)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(serviceRecommendation.saveRecommendation(userId,recommendation),HttpStatus.OK);
    }
}
