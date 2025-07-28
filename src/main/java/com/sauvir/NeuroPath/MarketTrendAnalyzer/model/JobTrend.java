package com.sauvir.NeuroPath.MarketTrendAnalyzer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class JobTrend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String location;
    private double growthRate;
    private int demandScore;
    private LocalDate forecastYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public int getDemandScore() {
        return demandScore;
    }

    public void setDemandScore(int demandScore) {
        this.demandScore = demandScore;
    }

    public LocalDate getForecastYear() {
        return forecastYear;
    }

    public void setForecastYear(LocalDate forecastYear) {
        this.forecastYear = forecastYear;
    }
}
