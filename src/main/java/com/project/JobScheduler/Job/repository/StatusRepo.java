package com.project.JobScheduler.Job.repository;

import com.project.JobScheduler.Job.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status,Long> {
    Status findByName(String name);
}
