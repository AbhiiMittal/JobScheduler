package com.project.JobScheduler.Subscription.controllers;

import com.project.JobScheduler.Subscription.dto.SubscriptionDTO;
import com.project.JobScheduler.Subscription.entity.Subscription;
import com.project.JobScheduler.Subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/create-new-subs/")
    public void createNewSubs(@RequestBody SubscriptionDTO subscriptionDTO){
        try{
            Subscription subscription = new Subscription();
            subscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());
            subscription.setHasSubscribed(subscriptionDTO.getHasSubscribed());
            subscription.setIsSubscribed(subscriptionDTO.getIsSubscribed());
            subscription.setRenewDate(subscriptionDTO.getRenewDate());
            subscription.setUserId(subscriptionDTO.getUserId());
            subscriptionService.createNew(subscription);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
