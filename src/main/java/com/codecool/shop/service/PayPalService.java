package com.codecool.shop.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

public interface PayPalService {
    Payment createPayment(Double total, String currency, String method, String intent,
              String description, String cancelURL, String successURL) throws PayPalRESTException;
    Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;
}
