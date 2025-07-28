package com.sauvir.NeuroPath.LearningPlatformIntegrator.Repository;

import com.sauvir.NeuroPath.LearningPlatformIntegrator.Model.CourseSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSuggestionRepository extends JpaRepository<CourseSuggestion,Integer> {

    @Query("SELECT c FROM CourseSuggestion c WHERE LOWER(c.skillTargeted) = LOWER(:skillTargeted)")
    List<CourseSuggestion> findCoursesBySkill(@Param("skillTargeted") String skillTargeted);
}
