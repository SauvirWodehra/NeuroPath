package com.sauvir.NeuroPath.Feedback.repository;

import com.sauvir.NeuroPath.Feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    @Query("SELECT f FROM Feedback f WHERE f.userId = :userId")
    List<Feedback> findFeedbackByUser(int userId);
}
