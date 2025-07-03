package com.project.JobScheduler.Job.repository;

import com.project.JobScheduler.Job.entity.TypeOfJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfJobRepo extends JpaRepository<TypeOfJob,Long> {
    TypeOfJob findByName(String name);
}
