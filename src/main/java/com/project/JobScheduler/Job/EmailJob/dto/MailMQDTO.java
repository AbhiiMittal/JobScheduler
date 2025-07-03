package com.project.JobScheduler.Job.EmailJob.dto;

public class MailMQDTO {
    Long jobId;
    EmailRequestDTO emailRequestDTO;
    String subject;
    String body;
    int retryDelay;

    public MailMQDTO(Long jobId, EmailRequestDTO emailRequestDTO, String subject, String body, int retryDelay) {
        this.jobId = jobId;
        this.emailRequestDTO = emailRequestDTO;
        this.subject = subject;
        this.body = body;
        this.retryDelay = retryDelay;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public EmailRequestDTO getEmailRequestDTO() {
        return emailRequestDTO;
    }

    public void setEmailRequestDTO(EmailRequestDTO emailRequestDTO) {
        this.emailRequestDTO = emailRequestDTO;
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

    public int getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(int retryDelay) {
        this.retryDelay = retryDelay;
    }
}
