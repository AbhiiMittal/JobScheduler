package com.project.JobScheduler.Job.dto;

import java.util.List;

public class JobRequestDTO {
    String jobName;
    String jobType;
    int occurrence;
    int lastStatus;
    int retryCount;
    int retryDelayInSeconds;
    String subject;
    String Body;
    List<String> To;
    String service;
    List<String> servicesUpdated;

    public JobRequestDTO() {
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
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
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public List<String> getTo() {
        return To;
    }

    public void setTo(List<String> to) {
        To = to;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<String> getServicesUpdated() {
        return servicesUpdated;
    }

    public void setServicesUpdated(List<String> servicesUpdated) {
        this.servicesUpdated = servicesUpdated;
    }
}
