package com.sauvir.NeuroPath.CareerRecommendationEngiene.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String recommendedSkill;
    private String reason;
    private double estimatedSalaryBoost;
    private LocalDate recommendedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRecommendedSkill() {
        return recommendedSkill;
    }

    public void setRecommendedSkill(String recommendedSkill) {
        this.recommendedSkill = recommendedSkill;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getEstimatedSalaryBoost() {
        return estimatedSalaryBoost;
    }

    public void setEstimatedSalaryBoost(double estimatedSalaryBoost) {
        this.estimatedSalaryBoost = estimatedSalaryBoost;
    }

    public LocalDate getRecommendedOn() {
        return recommendedOn;
    }

    public void setRecommendedOn(LocalDate recommendedOn) {
        this.recommendedOn = recommendedOn;
    }
}
