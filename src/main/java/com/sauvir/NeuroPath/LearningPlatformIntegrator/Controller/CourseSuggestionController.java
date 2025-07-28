package com.sauvir.NeuroPath.LearningPlatformIntegrator.Controller;

import com.sauvir.NeuroPath.LearningPlatformIntegrator.Model.CourseSuggestion;
import com.sauvir.NeuroPath.LearningPlatformIntegrator.Service.CourseSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseSuggestionController {

    @Autowired
    private CourseSuggestionService serviceCourseSuggestion;

    @GetMapping("/courses/skills/{skill}")
    public ResponseEntity<List<CourseSuggestion>> getCoursesBySkills(@PathVariable String skill){
        return new ResponseEntity<>(serviceCourseSuggestion.getCoursesBySkill(skill), HttpStatus.OK);
    }

    @PostMapping("/coursess")
    public ResponseEntity<CourseSuggestion> addCourse(@RequestBody CourseSuggestion courseSuggestion){
        return new ResponseEntity<>(serviceCourseSuggestion.addCourseSuggestion(courseSuggestion),HttpStatus.OK);
    }
}
