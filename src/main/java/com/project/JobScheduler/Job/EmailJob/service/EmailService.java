package com.project.JobScheduler.Job.EmailJob.service;

import org.springframework.http.ResponseEntity;

public interface EmailService {
    public ResponseEntity<?> sendEmail(String email,String subject,String body);
}
