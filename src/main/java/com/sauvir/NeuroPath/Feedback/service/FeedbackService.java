package com.sauvir.NeuroPath.Feedback.service;

import com.sauvir.NeuroPath.Exceptions.WrongId;
import com.sauvir.NeuroPath.Feedback.model.Feedback;
import com.sauvir.NeuroPath.Feedback.repository.FeedbackRepository;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repoFeedback;

    @Autowired
    private UsersRepository repoUser;

    public List<Feedback> getFeedbacksByUsers(int userId){
        Optional<Users> optionalUsers=repoUser.findById(userId);
        if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with id :"+" "+userId);
        return repoFeedback.findFeedbackByUser(userId);
    }

    public Feedback addFeedBack(int userId, Feedback fb){
        Optional<Users> optionalUsers=repoUser.findById(userId);
        if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with id :"+" "+userId);
        fb.setUserId(userId);
        return repoFeedback.save(fb);
    }
}
