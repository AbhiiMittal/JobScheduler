package com.project.JobScheduler.Job.EmailJob.dto;

import java.util.List;

public class EmailRequestDTO {
    String user;
    int repeatingTime;

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
