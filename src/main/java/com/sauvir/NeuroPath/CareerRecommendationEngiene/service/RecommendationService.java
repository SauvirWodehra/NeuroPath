package com.sauvir.NeuroPath.CareerRecommendationEngiene.service;

import com.sauvir.NeuroPath.CareerRecommendationEngiene.model.Recommendation;
import com.sauvir.NeuroPath.CareerRecommendationEngiene.repository.RecommendationRepository;
import com.sauvir.NeuroPath.Exceptions.WrongId;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository repoRecommendation;

    @Autowired
    private UsersRepository repoUsers;

    public List<Recommendation> getRecommendationsForUser(int userId){
        return repoRecommendation.findByUserId(userId);
    }

    public Recommendation saveRecommendation(int userId, Recommendation rec){
        Optional<Users> usersOptional=repoUsers.findById(userId);
        if(usersOptional.isEmpty()) throw new WrongId("No Id was Found with id :"+" "+userId);
        rec.setUserId(userId);
        return repoRecommendation.save(rec);
    }
}
