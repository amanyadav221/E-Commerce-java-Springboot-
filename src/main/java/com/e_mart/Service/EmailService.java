package com.e_mart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    public boolean sendOtpEmail(String toEmail, String otp) {
        try {
            if (mailSender == null) {
                System.err.println("JavaMailSender is null - SMTP configuration missing.");
                return false;
            }
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("yadavaman6940@gmail.com");
            message.setTo(toEmail);
            message.setSubject("E-Mart Account Password Reset OTP");
            message.setText("Dear Customer,\n\nYour OTP for resetting your E-Mart account password is: " + otp + "\n\nThis OTP is valid for 10 minutes. Do not share this OTP with anyone.\n\nThank you,\nE-Mart Shopping Team");

            mailSender.send(message);
            System.out.println("SUCCESS: OTP Email sent to " + toEmail);
            return true;
        } catch (Exception e) {
            System.err.println("ERROR: Failed to send OTP email to " + toEmail + ": " + e.getMessage());
            return false;
        }
    }
}
