package com.codecool.shop.service;

import com.paypal.api.payments.Payment;

public interface EmailService {
    void sendEmail(Payment payment);
}
