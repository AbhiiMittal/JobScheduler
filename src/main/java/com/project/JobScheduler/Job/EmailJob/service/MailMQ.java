package com.project.JobScheduler.Job.EmailJob.service;

import com.project.JobScheduler.Job.EmailJob.dto.MailMQDTO;

public interface MailMQ {

    void processEmailQueue(MailMQDTO mailMQDTO);
}
