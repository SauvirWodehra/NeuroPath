package com.sauvir.NeuroPath.Feedback.controller;

import com.sauvir.NeuroPath.Feedback.model.Feedback;
import com.sauvir.NeuroPath.Feedback.service.FeedbackService;
import com.sauvir.NeuroPath.UserProfile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FeedbackController {

    @Autowired
    private FeedbackService serviceFeedback;

    @Autowired
    private UsersService serviceUsers;

    @GetMapping("/feedback/{userId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByusers(@PathVariable int userId, Neo4jProperties.Authentication authentication){
        String loggedInUserName= authentication.getUsername();
        if(serviceUsers.findUserName(userId)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(serviceFeedback.getFeedbacksByUsers(userId), HttpStatus.OK);
    }

    @PostMapping("/feedback/{userId}")
    public ResponseEntity<Feedback> addFeedback(@PathVariable int userId, @RequestBody Feedback fb, Neo4jProperties.Authentication authentication){
        String loggedInUserName= authentication.getUsername();
        if(serviceUsers.findUserName(userId)!=loggedInUserName) return new ResponseEntity<>(HttpStatus.FORBIDDEN
        );
        return new ResponseEntity<>(serviceFeedback.addFeedBack(userId,fb),HttpStatus.OK);
    }
}
