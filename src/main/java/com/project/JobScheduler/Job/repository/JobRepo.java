package com.project.JobScheduler.Job.repository;

import com.project.JobScheduler.Job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Long> {
    List<Job> findByLastStatus(int jobStatus);
}
