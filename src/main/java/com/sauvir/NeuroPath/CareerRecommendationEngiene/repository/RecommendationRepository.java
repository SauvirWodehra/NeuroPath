package com.sauvir.NeuroPath.CareerRecommendationEngiene.repository;

import com.sauvir.NeuroPath.CareerRecommendationEngiene.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Integer> {

    @Query("SELECT r FROM Recommendation r WHERE r.userId = :userId")
    List<Recommendation> findByUserId(@Param("userId") int userId);
}
