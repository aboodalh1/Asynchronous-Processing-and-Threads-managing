package com.example.learing.sync.service;

import com.example.learing.sync.DTO.Order;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;


    public Order processOrder(Order order) throws InterruptedException {
        order.setTrackingId(UUID.randomUUID().toString());
        if (inventoryService.checkProductAvailability(order.getProductId())) {
            //handle exception here
            paymentService.processPayment(order);
        } else {
            throw new RuntimeException("Technical issue please retry");
        }
        return order;
    }

    @Async("customAsyncTask")
    public void notifyUser(Order order) throws InterruptedException {
        Thread.sleep(4000L);
        log.info("Notified to the user {}", Thread.currentThread().getName());
    }
    @Async("customAsyncTask")
    public void assignVendor(Order order) throws InterruptedException {
        Thread.sleep(5000L);
        log.info("Assign order to vendor {}", Thread.currentThread().getName());
    }
    @Async("customAsyncTask")
    public void packaging(Order order) throws InterruptedException {
        Thread.sleep(2000L);
        log.info("Order packaging completed {}", Thread.currentThread().getName());
    }
    @Async("customAsyncTask")
    public void assignDeliveryPartner(Order order) throws InterruptedException {
        Thread.sleep(10000L);
        log.info("Delivery partner assigned {}", Thread.currentThread().getName());
    }
    @Async("customAsyncTask")
    public void assignTrailerAndDispatch(Order order) throws InterruptedException {
        Thread.sleep(3000L);
        log.info("Trailer assigned and Order dispatched {}", Thread.currentThread().getName());
    }
}
