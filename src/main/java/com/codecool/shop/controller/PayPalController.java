package com.codecool.shop.controller;

import com.codecool.shop.model.Customer;
import com.codecool.shop.model.Order;
import com.codecool.shop.service.BasketService;
import com.codecool.shop.service.CustomerService;
import com.codecool.shop.service.EmailService;
import com.codecool.shop.service.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PayPalController {

    private final PayPalService payPalService;
    private final CustomerService customerService;
    private final BasketService basketService;
    private final EmailService emailService;

    @Autowired
    public PayPalController(PayPalService payPalService, CustomerService customerService,
                            BasketService basketService, EmailService emailService) {
        this.payPalService = payPalService;
        this.customerService = customerService;
        this.basketService = basketService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String finalizeTransaction(Model model, Authentication authentication) {
        Customer customer = customerService.getCurrentlyLoggedInCustomer(authentication);
        model.addAttribute("itemsList", basketService.listItemsInBasket(customer));
        model.addAttribute("order", new Order());
        return "payment/payment-form";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String payment(@ModelAttribute("order") Order order) {
        String redirectToPage = "";
        try {
            Payment payment = payPalService.createPayment(order.getOrderPrice(), order.getOrderCurrency(),
                    order.getOrderMethod(), order.getOrderIntent(), order.getOrderDescription(),
                    "http://localhost:8080/pay/cancel",
                    "http://localhost:8080/pay/success");
            for (Links link : payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    redirectToPage = "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return redirectToPage;
    }

    @RequestMapping(value = "/pay/cancel", method = RequestMethod.GET)
    public String cancelPay() {
        return "payment/cancel-payment";
    }

    @RequestMapping(value = "/pay/success", method = RequestMethod.GET)
    public String successPay(@RequestParam(name = "paymentId") String paymentId,
                             @RequestParam(name = "PayerID") String payerId,
                             Authentication authentication) {
        String redirectToPage = "";
        Customer customer = customerService.getCurrentlyLoggedInCustomer(authentication);
        try {
            Payment payment = payPalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                emailService.sendEmail(payment);
                basketService.removeAllProductsFromBasket(customer);
                redirectToPage = "payment/success-payment";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return redirectToPage;
    }
}
