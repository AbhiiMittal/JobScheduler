package com.project.JobScheduler.Job.EmailJob.service;

import com.project.JobScheduler.User.repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> sendEmail(String id,String subject,String body) {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            String email = userRepository.getById(Long.valueOf(id)).getEmailId();
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(message);
            return ResponseEntity.ok("sent successfully");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}

