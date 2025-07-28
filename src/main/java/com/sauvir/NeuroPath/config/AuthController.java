package com.sauvir.NeuroPath.config;

//import com.sauvir.NeuroPath.Auth.model.*;
import com.sauvir.NeuroPath.EmailConfigurations.Email;
import com.sauvir.NeuroPath.config.JwtService;
import com.sauvir.NeuroPath.UserProfile.model.Users;
import com.sauvir.NeuroPath.UserProfile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired private UsersRepository usersRepo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;
    @Autowired private Email senderEmail;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        if (usersRepo.existsByUsername(req.getUsername())) {
            return ResponseEntity.badRequest().body("Username already taken");
        }
        Users u = new Users();
        u.setUsername(req.getUsername());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setLocation(req.getLocation());
        u.setRole(req.getRole());
        u.setEducation(req.getEducation());
        usersRepo.save(u);

        String token = jwtService.generateToken(u.getUsername());
        senderEmail.sendEmail(
                u.getEmail(),
                "🎉 You're Officially Part of NeuroPath – Let's Get Started!",
                """
                Hello %s,

                Welcome to NeuroPath! We're excited to have you join our growing community of curious minds and passionate learners.

                With your background in %s and interests in %s, you're perfectly positioned to thrive here. Our platform is designed to help you grow, connect, and make real impact.

                Stay curious, stay driven — and let’s shape the future of neuroscience together! 🧠🚀

                Best regards,
                Team NeuroPath
                """.formatted(
                        u.getName() != null ? u.getName() : "there",
                        u.getSkills() != null && !u.getSkills().isEmpty() ? String.join(", ", u.getSkills()) : "various domains",
                        u.getInterests() != null && !u.getInterests().isEmpty() ? String.join(", ", u.getInterests()) : "diverse areas"
                )
        );
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        String token = jwtService.generateToken(req.getUsername());
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
//
