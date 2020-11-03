package com.application.kafkaspringbootdemo.service;

import com.application.kafkaspringbootdemo.kafkaRepository.PodownloadRepository;
import com.application.kafkaspringbootdemo.model.PoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AppListener {
    @Autowired
    PodownloadRepository podownloadRepository;

    @KafkaListener(topics = "kafka-topic1",groupId = "my-springbootapp", containerFactory = "kafkaListenerContainerFactory")
    public void listenToKafkaTopic(PoDetails poDetails){
        System.out.println("Message received from Kafka topic is  ::::  ");
        podownloadRepository.save(poDetails);
        System.out.println(poDetails);
    }

}

