package com.sauvir.NeuroPath.LearningPlatformIntegrator.Service;

import com.sauvir.NeuroPath.LearningPlatformIntegrator.Model.CourseSuggestion;
import com.sauvir.NeuroPath.LearningPlatformIntegrator.Repository.CourseSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSuggestionService {

    @Autowired
    private CourseSuggestionRepository repoCourseSuggestion;

    public List<CourseSuggestion> getCoursesBySkill(String skillTargeted){
        return repoCourseSuggestion.findCoursesBySkill(skillTargeted);
    }

    public CourseSuggestion addCourseSuggestion(CourseSuggestion courseSuggestion){
        return repoCourseSuggestion.save(courseSuggestion);
    }
}
