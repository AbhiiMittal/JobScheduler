package com.project.JobScheduler.User.entity;

import jakarta.persistence.*;

@Entity
@Table(name="USER_DATA")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    @SequenceGenerator(name = "user_seq",sequenceName = "user_seq",allocationSize = 1)
    @Column(name = "USER_ID")
    Long id;
    @Column(name = "EMAIL_ID")
    String emailId;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

