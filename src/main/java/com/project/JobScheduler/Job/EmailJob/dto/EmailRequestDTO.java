package com.project.JobScheduler.Job.EmailJob.dto;

import java.io.Serializable;
import java.util.List;

public class EmailRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    String user;
    int repeatingTime;

    public EmailRequestDTO() {
    }

    public EmailRequestDTO(String user, int repeatingTime) {
        this.user = user;
        this.repeatingTime = repeatingTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRepeatingTime() {
        return repeatingTime;
    }

    public void setRepeatingTime(int repeatingTime) {
        this.repeatingTime = repeatingTime;
    }
}
