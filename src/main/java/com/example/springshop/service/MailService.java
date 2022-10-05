package com.example.springshop.service;

import com.example.springshop.domain.Order;
import com.example.springshop.domain.User;

public interface MailService {
    void sendOrderMessage(User user, Order order);
}
