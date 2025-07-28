package com.sauvir.NeuroPath.UserProfile.service;

import com.sauvir.NeuroPath.EmailConfigurations.Email;
import com.sauvir.NeuroPath.Exceptions.WrongId;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sauvir.NeuroPath.EmailConfigurations.Email;


import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repoUsers;


    @Autowired
    private Email emailService;

    public Users saveUser(Users users){
        System.out.println("User saved..");
        emailService.sendEmail(
                users.getEmail(),
                "🎉 You're Officially Part of NeuroPath – Let's Get Started!",
                """
                Hello %s,

                Welcome to NeuroPath! We're excited to have you join our growing community of curious minds and passionate learners.

                With your background in %s and interests in %s, you're perfectly positioned to thrive here. Our platform is designed to help you grow, connect, and make real impact.

                Stay curious, stay driven — and let’s shape the future of neuroscience together! 🧠🚀

                Best regards,
                Team NeuroPath
                """.formatted(
                        users.getName() != null ? users.getName() : "there",
                        users.getSkills() != null && !users.getSkills().isEmpty() ? String.join(", ", users.getSkills()) : "various domains",
                        users.getInterests() != null && !users.getInterests().isEmpty() ? String.join(", ", users.getInterests()) : "diverse areas"
                )
        );

        return repoUsers.save(users);
    }

    public Users getUsersById(int id){
      Optional<Users> optionalUsers= repoUsers.findById(id);
      if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with Id :"+" "+id);
      Users users=optionalUsers.get();
      System.out.println("user was searched with user id :"+" "+id);
      return users;
    }

    public Users updateUsers(int id, Users updateduser){
        Optional<Users> optionalUsers= repoUsers.findById(id);
        if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with Id :"+" "+id);
        Users users=optionalUsers.get();
        users.setName(updateduser.getName());
        users.setEmail(updateduser.getEmail());
        users.setLocation(updateduser.getLocation());
        users.setRole(updateduser.getRole());
        users.setSkills(updateduser.getSkills());
        users.setEducation(updateduser.getEducation());
        users.setInterests(updateduser.getInterests());
        System.out.println("User updated");
        repoUsers.save(users);
        return users;
    }

    public void deleteUsers(int id){
        Optional<Users> optionalUsers= repoUsers.findById(id);
        if(optionalUsers.isEmpty()) throw new WrongId("No User was Found with Id :"+" "+id);
        Users users=optionalUsers.get();
        repoUsers.delete(users);
    }


    public String findUserName(int id) {
       Optional<Users> optionalUsers= repoUsers.findById(id);
       if(optionalUsers.isEmpty()) throw new WrongId("No id exists By user Id :"+" "+id);
       Users users= optionalUsers.get();
       return users.getUsername();
    }
}

