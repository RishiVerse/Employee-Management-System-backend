package com.managementportal.ems.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PerformanceDto {

    private String performanceName;
    private String department;
    private String jobTitle;
    private LocalDate dateOfJoining;
    private String managerName;

    // Performance-related attributes
    private double performanceRating;
    private int projectsCompleted;
    private int tasksCompleted;
    private int hoursWorked;
    private int daysAbsent;
    private LocalDate lastPerformanceReviewDate;
    private String performanceFeedback;
    private boolean isEligibleForPromotion;
    private double salaryIncrement;

    // Private constructor to prevent direct instantiation
    private PerformanceDto() {
    }

    // Static inner Builder class
    public static class PerformanceDtoBuilder {
        private String performanceName;
        private String department;
        private String jobTitle;
        private LocalDate dateOfJoining;
        private String managerName;

        // Performance-related attributes
        private double performanceRating;
        private int projectsCompleted;
        private int tasksCompleted;
        private int hoursWorked;
        private int daysAbsent;
        private LocalDate lastPerformanceReviewDate;
        private String performanceFeedback;
        private boolean isEligibleForPromotion;
        private double salaryIncrement;

        public PerformanceDtoBuilder setPerformanceName(String performanceName) {
            this.performanceName = performanceName;
            return this;
        }

        public PerformanceDtoBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public PerformanceDtoBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public PerformanceDtoBuilder setDateOfJoining(LocalDate dateOfJoining) {
            this.dateOfJoining = dateOfJoining;
            return this;
        }

        public PerformanceDtoBuilder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public PerformanceDtoBuilder setPerformanceRating(double performanceRating) {
            this.performanceRating = performanceRating;
            return this;
        }

        public PerformanceDtoBuilder setProjectsCompleted(int projectsCompleted) {
            this.projectsCompleted = projectsCompleted;
            return this;
        }

        public PerformanceDtoBuilder setTasksCompleted(int tasksCompleted) {
            this.tasksCompleted = tasksCompleted;
            return this;
        }

        public PerformanceDtoBuilder setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
            return this;
        }

        public PerformanceDtoBuilder setDaysAbsent(int daysAbsent) {
            this.daysAbsent = daysAbsent;
            return this;
        }

        public PerformanceDtoBuilder setLastPerformanceReviewDate(LocalDate lastPerformanceReviewDate) {
            this.lastPerformanceReviewDate = lastPerformanceReviewDate;
            return this;
        }

        public PerformanceDtoBuilder setPerformanceFeedback(String performanceFeedback) {
            this.performanceFeedback = performanceFeedback;
            return this;
        }

        public PerformanceDtoBuilder setEligibleForPromotion(boolean isEligibleForPromotion) {
            this.isEligibleForPromotion = isEligibleForPromotion;
            return this;
        }

        public PerformanceDtoBuilder setSalaryIncrement(double salaryIncrement) {
            this.salaryIncrement = salaryIncrement;
            return this;
        }

        // Build method to create the final PerformanceDto object
        public PerformanceDto build() {
            PerformanceDto performanceDto = new PerformanceDto();
            performanceDto.setPerformanceName(this.performanceName);
            performanceDto.setDepartment(this.department);
            performanceDto.setJobTitle(this.jobTitle);
            performanceDto.setDateOfJoining(this.dateOfJoining);
            performanceDto.setManagerName(this.managerName);
            performanceDto.setPerformanceRating(this.performanceRating);
            performanceDto.setProjectsCompleted(this.projectsCompleted);
            performanceDto.setTasksCompleted(this.tasksCompleted);
            performanceDto.setHoursWorked(this.hoursWorked);
            performanceDto.setDaysAbsent(this.daysAbsent);
            performanceDto.setLastPerformanceReviewDate(this.lastPerformanceReviewDate);
            performanceDto.setPerformanceFeedback(this.performanceFeedback);
            performanceDto.setEligibleForPromotion(this.isEligibleForPromotion);
            performanceDto.setSalaryIncrement(this.salaryIncrement);
            return performanceDto;
        }
    }


}
