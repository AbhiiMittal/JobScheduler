package com.project.JobScheduler.Job.EmailJob.service;

import com.project.JobScheduler.Job.EmailJob.dto.EmailRequestDTO;
import com.project.JobScheduler.Job.EmailJob.dto.MailMQDTO;
import com.project.JobScheduler.Job.entity.JobFailureException;
import com.project.JobScheduler.Job.repository.JobFailureExceptionRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class MailMQImpl implements MailMQ {
    @Autowired
    EmailService emailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    JobFailureExceptionRepo jobFailureExceptionRepo;

    @Override
    @RabbitListener(queues = "mail-queue")
    public void processEmailQueue(MailMQDTO mailMQDTO) {
        try {
            EmailRequestDTO req = mailMQDTO.getEmailRequestDTO();
            String subject = mailMQDTO.getSubject();
            String body = mailMQDTO.getBody();
            int retryDelay = mailMQDTO.getRetryDelay();
            Long jobId = mailMQDTO.getJobId();
            ResponseEntity<?> response = emailService.sendEmail(req.getUser(),subject,body);
            if (response == null || !response.getStatusCode().is2xxSuccessful()){
                req.setRepeatingTime(req.getRepeatingTime()-1);
                if(req.getRepeatingTime()==0){
                    // handle failure
                    jobFailureExceptionRepo.save(new JobFailureException(jobId,String.valueOf(response.getBody())));
                }else{
                    rabbitTemplate.convertAndSend("mail-queue",mailMQDTO);
                }
            }
        } catch (Exception e) {

            // Handle failure (e.g. retry or send to dead-letter queue)
        }
    }

}
