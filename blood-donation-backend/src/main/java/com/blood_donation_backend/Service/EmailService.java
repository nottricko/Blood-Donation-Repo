package com.blood_donation_backend.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Method to send an email
    public boolean sendEmail(String to, String subject, String text) {
        try {
            // Create a MimeMessage to send the email
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Set the email properties
            helper.setTo(to);        // recipient's email
            helper.setSubject(subject);   // email subject
            helper.setText(text, true); // email body text, 'true' means HTML content
            helper.setFrom("your-email@gmail.com"); // sender's email

            // Send the email
            mailSender.send(message);
            return true; // Return true if email is sent successfully
        } catch (MessagingException | MailException e) {
            e.printStackTrace();  // Log the exception
            return false; // Return false if there was an error sending the email
        }
    }
}
