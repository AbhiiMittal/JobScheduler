package com.project.JobScheduler.Subscription.service;

import com.project.JobScheduler.Subscription.entity.Subscription;
import org.springframework.stereotype.Service;


public interface SubscriptionService {
    String createNew(Subscription subscription);
}
