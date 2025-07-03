package com.project.JobScheduler.Job.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "JOB_SEQ")
    @SequenceGenerator(name = "JOB_SEQ",sequenceName = "JOB_SEQ",allocationSize = 1)
    Long id;
    String jobName;
    int jobType;
    int occurrence;
    int lastStatus;
    int retryCount;
    int retryDelayInSeconds;
    String subject;
    String body;
    @Lob
    @Column(name = "to_list")
    private String to;
    String service;
    @Lob
    String servicesUpdated;

    public Job() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    public int getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(int lastStatus) {
        this.lastStatus = lastStatus;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public int getRetryDelayInSeconds() {
        return retryDelayInSeconds;
    }

    public void setRetryDelayInSeconds(int retryDelayInSeconds) {
        this.retryDelayInSeconds = retryDelayInSeconds;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServicesUpdated() {
        return servicesUpdated;
    }

    public void setServicesUpdated(String servicesUpdated) {
        this.servicesUpdated = servicesUpdated;
    }
}
