package com.sauvir.NeuroPath.MarketTrendAnalyzer.service;

import com.sauvir.NeuroPath.MarketTrendAnalyzer.model.JobTrend;
import com.sauvir.NeuroPath.MarketTrendAnalyzer.repository.JobTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTrendService {

    @Autowired
    private JobTrendRepository repoJobTrend;

    public List<JobTrend> getAllJobTrends(){
        return repoJobTrend.findAll();
    }

    public List<JobTrend> getJobTrendByLocation(String location){
        return repoJobTrend.findByLocation(location);
    }

    public JobTrend saveTrend(JobTrend jobtrend){
        return repoJobTrend.save(jobtrend);
    }
}
