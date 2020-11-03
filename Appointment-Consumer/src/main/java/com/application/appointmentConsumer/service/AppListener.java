package com.application.appointmentConsumer.service;

import com.application.appointmentConsumer.model.AppointmentScheduling;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AppListener {

    @KafkaListener(topics = "springboot-kafka",groupId = "my-springbootapp", containerFactory = "kafkaListenerContainerFactory")
    public void listenToKafkaTopic(AppointmentScheduling appointmentScheduling){
        System.out.println("Message received from Kafka topic is  ::::  ");
        System.out.println(appointmentScheduling);
    }

}

