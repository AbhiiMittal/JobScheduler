package com.project.JobScheduler.Subscription.repository;

import com.project.JobScheduler.Subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionRepo extends JpaRepository<Subscription,Long> {
    List<Subscription> findByRenewDate(String renewDate);
    List<Subscription> findByRenewDateAndIsSubscribed(String renewDate, int isSubscribed);

}
