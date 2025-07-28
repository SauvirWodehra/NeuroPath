package com.sauvir.NeuroPath.UserProfile.repository;

import com.sauvir.NeuroPath.UserProfile.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Optional<Users> findByUsername(@Param("username") String username);

    @Query("SELECT COUNT(u) > 0 FROM Users u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);
}
