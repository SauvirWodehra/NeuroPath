package com.sauvir.NeuroPath.MarketTrendAnalyzer.controller;

import com.sauvir.NeuroPath.MarketTrendAnalyzer.model.JobTrend;
import com.sauvir.NeuroPath.MarketTrendAnalyzer.service.JobTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class JobTrendController {

    @Autowired
    private JobTrendService serviceJobTrend;

    @GetMapping("/trends")
    public ResponseEntity<List<JobTrend>> getAllJobTrends(){
        return new ResponseEntity<>(serviceJobTrend.getAllJobTrends(), HttpStatus.OK);
    }

    @GetMapping("/trends/{location}")
    public ResponseEntity<List<JobTrend>> getAllJobTrendsByLocation(@PathVariable String location){
        return new ResponseEntity<>(serviceJobTrend.getJobTrendByLocation(location),HttpStatus.OK);
    }

    @PostMapping("/trends")
    public ResponseEntity<JobTrend> addJobTrend(@RequestBody JobTrend jobTrend){
        return new ResponseEntity<>(serviceJobTrend.saveTrend(jobTrend),HttpStatus.OK);
    }
}
