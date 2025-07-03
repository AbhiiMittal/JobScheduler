package com.project.JobScheduler.Job.service;

import com.project.JobScheduler.Job.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getJobs();
    String createJob(Job job);
}
