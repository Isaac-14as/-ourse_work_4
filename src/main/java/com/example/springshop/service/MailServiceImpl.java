package com.example.springshop.service;

import com.example.springshop.domain.Order;
import com.example.springshop.domain.OrderDetails;
import com.example.springshop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void sendOrderMessage(User user, Order order) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());//кому
        StringBuilder messageText = new StringBuilder(user.getName());
        messageText.append("\nОгромное спасибо за ваш заказ!\n");
        for (OrderDetails detail: order.getDetails()) {
            messageText.append(detail.getProduct().getTitle()).append(" * ")
            .append(detail.getAmount()).append('\n');
        }
        messageText.append("\nОбщая стоимость: ").append(order.getSum());
        message.setText(messageText.toString());//текст письма
        message.setSubject("Заказ на сайте");//тема письма(чтобы письмо не улетело в спам)
        mailSender.send(message);//отправка сообщения
    }
}
