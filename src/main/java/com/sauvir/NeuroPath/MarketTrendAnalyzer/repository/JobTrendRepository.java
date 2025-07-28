package com.sauvir.NeuroPath.MarketTrendAnalyzer.repository;

import com.sauvir.NeuroPath.MarketTrendAnalyzer.model.JobTrend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTrendRepository extends JpaRepository<JobTrend,Integer> {
    @Query("SELECT jt FROM JobTrend jt WHERE jt.location = :location")
    List<JobTrend> findByLocation(@Param("location") String location);
}
