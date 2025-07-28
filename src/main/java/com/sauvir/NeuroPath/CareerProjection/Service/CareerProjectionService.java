package com.sauvir.NeuroPath.CareerProjection.Service;

import com.sauvir.NeuroPath.CareerProjection.Model.CareerProjection;
import com.sauvir.NeuroPath.CareerProjection.Repository.CareerProjectionRepository;
import com.sauvir.NeuroPath.Exceptions.WrongId;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerProjectionService {

    @Autowired
    private CareerProjectionRepository repoCareerProjection;


    @Autowired
    private UsersRepository repoUsers;

    public List<CareerProjection> getProjectionForUser(int UserId){
        Optional<Users> optionalUsers=repoUsers.findById(UserId);
        if(optionalUsers.isEmpty()) throw new WrongId("No user exists By Id :"+" "+UserId);
        return repoCareerProjection.findByUserId(UserId);
    }

    public CareerProjection saveProjection(CareerProjection careerProjection){
        int UserId=careerProjection.getUserId();
        Optional<Users> optionalUsers=repoUsers.findById(UserId);
        if(optionalUsers.isEmpty()) throw new WrongId("No user exists By Id :"+" "+UserId);
        return repoCareerProjection.save(careerProjection);

    }
}
