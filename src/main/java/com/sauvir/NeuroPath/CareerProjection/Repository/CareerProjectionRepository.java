package com.sauvir.NeuroPath.CareerProjection.Repository;

import com.sauvir.NeuroPath.CareerProjection.Model.CareerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerProjectionRepository extends JpaRepository<CareerProjection,Integer> {
    @Query("SELECT c FROM CareerProjection c WHERE c.userId = :userId")
    List<CareerProjection> findByUserId(@Param("userId") int userId);
}
