package com.project.JobScheduler.Job.service;

import com.project.JobScheduler.Job.entity.Job;
import com.project.JobScheduler.Job.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepo jobRepo;

    @Override
    public List<Job> getJobs() {
        return jobRepo.findAll();
    }

    @Override
    public String createJob(Job job) {
        try {
            jobRepo.save(job);
            return "job created successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
