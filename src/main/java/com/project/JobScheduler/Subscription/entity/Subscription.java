package com.project.JobScheduler.Subscription.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SUBS_SEQ")
    @SequenceGenerator(name = "SUBS_SEQ",sequenceName = "SUBS_SEQ",allocationSize = 1)
    @Column(name = "SUBS_ID")
    Long id;
    @Column(name = "USER_ID")
    Long userId;
    @Column(name = "IS_SUBS")
    int isSubscribed;
    @Column(name = "HAS_SUBS")
    int hasSubscribed;
    @Column(name = "RENEW_DATE")
    String renewDate;
    @Column(name = "SUBS_TYPE")
    int subscriptionType;

    public Subscription() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
