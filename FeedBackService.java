package com.creativeFuel.feedback_Request.service;

import com.creativeFuel.feedback_Request.dao.FeedBackRepo;
import com.creativeFuel.feedback_Request.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {

    @Autowired
    private FeedBackRepo feedbackRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Feedback submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    public String sendEmail(Feedback feedback) {
        Feedback savedFeedback=feedbackRepository.save(feedback);
        sendNotification(savedFeedback);
        return "Mail Send";
    }

    private void sendNotification(Feedback savedFeedback) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(savedFeedback.getEmail());
        message.setFrom("akshat.t463@gmail.com");
        message.setSubject("New Feedback Submitted");
        message.setText("New FeedBack From" + savedFeedback.getEmail() + "Message" + savedFeedback.getMessage());
        mailSender.send(message);
    }
}
