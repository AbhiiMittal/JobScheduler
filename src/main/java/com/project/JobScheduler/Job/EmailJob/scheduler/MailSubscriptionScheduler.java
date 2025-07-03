package com.project.JobScheduler.Job.EmailJob.scheduler;

import com.project.JobScheduler.Job.EmailJob.dto.EmailRequestDTO;
import com.project.JobScheduler.Job.EmailJob.dto.MailDto;
import com.project.JobScheduler.Job.EmailJob.dto.MailMQDTO;
import com.project.JobScheduler.Job.EmailJob.service.EmailServiceImpl;
import com.project.JobScheduler.Job.entity.Job;
import com.project.JobScheduler.Job.entity.Status;
import com.project.JobScheduler.Job.repository.JobRepo;
import com.project.JobScheduler.Job.repository.StatusRepo;
import com.project.JobScheduler.Subscription.entity.Subscription;
import com.project.JobScheduler.Subscription.repository.SubscriptionRepo;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import com.project.JobScheduler.User.entity.User;
import com.project.JobScheduler.User.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MailSubscriptionScheduler {

    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    JobRepo jobRepo;

    @Autowired
    StatusRepo statusRepo;

    @Transactional
    @Scheduled(fixedRate = 86400000)
    public void runDueSubscription(){
        try {
            String tommorowDate = String.valueOf(LocalDate.now().plusDays(1));
            System.out.println(tommorowDate);
            List<Subscription> dueSubs = subscriptionRepo.findByRenewDateAndIsSubscribed(tommorowDate,1);
            for (Subscription subscription : dueSubs) {
                System.out.println(subscription.getRenewDate());
                User user = userRepository.getById(subscription.getUserId());
                System.out.println("sending mail to: " +user.getEmailId());
//                emailService.sendEmail(new EmailRequestDTO(user.getEmailId(), "Hi", "Subscription expired"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void runSendMail(MailDto mailDto){
        Job job = jobRepo.getReferenceById(mailDto.getJobId());
        try {
            Status status = statusRepo.findByName("RUNNING");
            job.setLastStatus(status.getId());
            int repeatingTime = mailDto.getRetryCount();
            int retryDelay = mailDto.getRetryDelayInSeconds();
            List<String> users = mailDto.getTo();
            for(String user : users){
                rabbitTemplate.convertAndSend("mail-queue", new MailMQDTO(mailDto.getJobId(),new EmailRequestDTO(user,repeatingTime),mailDto.getSubject(), mailDto.getBody(),retryDelay));
            }
            status = statusRepo.findByName("SUCCESS");
            job.setLastStatus(status.getId());
        } catch (Exception e) {
            Status status = statusRepo.findByName("FAILED");
            job.setLastStatus(status.getId());
            throw new RuntimeException(e);
        }
    }
}
