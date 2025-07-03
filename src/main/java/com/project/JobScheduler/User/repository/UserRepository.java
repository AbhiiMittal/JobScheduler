package com.project.JobScheduler.User.repository;

import com.project.JobScheduler.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getById(Long id);
}
