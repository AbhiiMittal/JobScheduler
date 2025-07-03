package com.project.JobScheduler.Job.entity;

import jakarta.persistence.*;

@Entity
public class JobFailureException {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "JOB_FAILURE_SEQ")
    @SequenceGenerator(name = "JOB_FAILURE_SEQ",sequenceName = "JOB_FAILURE_SEQ",allocationSize = 1)
    Long id;
    Long jobId;
    String errorMsg;

    public JobFailureException(Long jobId, String errorMsg) {
        this.jobId = jobId;
        this.errorMsg = errorMsg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
