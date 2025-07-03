package com.project.JobScheduler.Job.repository;

import com.project.JobScheduler.Job.entity.JobFailureException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobFailureExceptionRepo extends JpaRepository<JobFailureException,Long> {
}
