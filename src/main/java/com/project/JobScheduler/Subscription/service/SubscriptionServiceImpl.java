package com.project.JobScheduler.Subscription.service;

import com.project.JobScheduler.Subscription.entity.Subscription;
import com.project.JobScheduler.Subscription.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Override
    public String createNew(Subscription subscription) {
        try {
            subscriptionRepo.save(subscription);
            return "subscription added successfully";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
