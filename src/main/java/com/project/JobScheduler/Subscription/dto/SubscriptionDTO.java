package com.project.JobScheduler.Subscription.dto;

import jakarta.persistence.Column;

public class SubscriptionDTO {
    Long userId;
    int isSubscribed;
    int hasSubscribed;
    String renewDate;
    int subscriptionType;

    public SubscriptionDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(int isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public int getHasSubscribed() {
        return hasSubscribed;
    }

    public void setHasSubscribed(int hasSubscribed) {
        this.hasSubscribed = hasSubscribed;
    }

    public String getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(String renewDate) {
        this.renewDate = renewDate;
    }

    public int getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(int subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
