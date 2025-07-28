package com.sauvir.NeuroPath.CareerProjection.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CareerProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String projectedRole;
    private double expectedSalary;
    private LocalDate projectedYear;
    private String trendComment;

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

    public String getProjectedRole() {
        return projectedRole;
    }

    public void setProjectedRole(String projectedRole) {
        this.projectedRole = projectedRole;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public LocalDate getProjectedYear() {
        return projectedYear;
    }

    public void setProjectedYear(LocalDate projectedYear) {
        this.projectedYear = projectedYear;
    }

    public String getTrendComment() {
        return trendComment;
    }

    public void setTrendComment(String trendComment) {
        this.trendComment = trendComment;
    }
}
