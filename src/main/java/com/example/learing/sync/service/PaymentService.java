package com.example.learing.sync.service;
import com.example.learing.sync.DTO.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@Slf4j
public class PaymentService {
    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
    public void processPayment(Order order) throws InterruptedException {
        log.info("initiate payment for order " + order.getProductId());
        //call actual payment gateway
        Thread.sleep(2000L);
        log.info("completed payment for order " + order.getProductId());
    }
}
