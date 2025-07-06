package com.project.JobScheduler.Job.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.JobScheduler.Job.EmailJob.dto.MailDto;
import com.project.JobScheduler.Job.EmailJob.scheduler.MailSubscriptionScheduler;
import com.project.JobScheduler.Job.dto.JobRequestDTO;
import com.project.JobScheduler.Job.entity.Job;
import com.project.JobScheduler.Job.entity.TypeOfJob;
import com.project.JobScheduler.Job.repository.StatusRepo;
import com.project.JobScheduler.Job.repository.TypeOfJobRepo;
import com.project.JobScheduler.Job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RestController
public class JobController {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JobService jobService;

    @Autowired
    StatusRepo statusRepo;

    @Autowired
    TypeOfJobRepo typeOfJobRepo;

    @Autowired
    MailSubscriptionScheduler mailSubscriptionScheduler;

    @GetMapping("/getAllJobs")
    List<Job> getAllJobs(){
        return jobService.getJobs();
    }

    @PostMapping("/create-job")
    String createNewJob(@RequestBody JobRequestDTO jobRequestDTO){
        try{
            Job job = new Job();
            int status = statusRepo.findByName("PENDING").getId();
            job.setLastStatus(status);
            job.setOccurrence(jobRequestDTO.getOccurrence());
            job.setJobName(jobRequestDTO.getJobName());
            job.setBody(jobRequestDTO.getBody());
            job.setRetryCount(jobRequestDTO.getRetryCount());
            TypeOfJob typeOfJob = typeOfJobRepo.findByName(jobRequestDTO.getJobType());
            job.setJobType(typeOfJob.getId());
            job.setRetryDelayInSeconds(jobRequestDTO.getRetryDelayInSeconds());
            job.setSubject(jobRequestDTO.getSubject());
            job.setTo(objectMapper.writeValueAsString(jobRequestDTO.getTo()));
            job.setService(jobRequestDTO.getService());
            job.setServicesUpdated(objectMapper.writeValueAsString(jobRequestDTO.getServicesUpdated()));
            jobService.createJob(job);
            return "sent";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
