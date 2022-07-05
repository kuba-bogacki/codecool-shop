package com.codecool.shop.service;

import com.paypal.api.payments.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplementation implements EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImplementation(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Payment payment) throws MailException {

        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setFrom("jb.bogacki@gmail.com");
        emailMessage.setTo(payment.getPayer().getPayerInfo().getEmail());
        emailMessage.setSubject("We have received your order nr " +
                payment.getTransactions().get(0).getRelatedResources().get(0).getOrder().getId());
        emailMessage.setText("Hi " + payment.getPayer().getPayerInfo().getFirstName() + "!\n" +
                "Team of your the most liked shop from this side!\n" +
                "Below you find the shipping information for your order:\n" +
                "Customer: " + payment.getTransactions().get(0).getItemList().getShippingAddress().getRecipientName() + "\n" +
                "Address: " + payment.getTransactions().get(0).getItemList().getShippingAddress().getLine1() + "\n" +
                "Postal code: " + payment.getTransactions().get(0).getItemList().getShippingAddress().getPostalCode() + "\n" +
                "State: " + payment.getTransactions().get(0).getItemList().getShippingAddress().getState() + "\n" +
                "Thanks for shopping, see you soon! :)");
        javaMailSender.send(emailMessage);
        System.out.println("Email send successfully");
    }
}
