package com.project.JobScheduler.Job.EmailJob.dto;

import java.util.List;

public class MailDto {
    Long jobId;
    int occurrence;
    int lastStatus;
    int retryCount;
    int retryDelayInSeconds;
    String subject;
    String Body;
    List<String> To;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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

}
