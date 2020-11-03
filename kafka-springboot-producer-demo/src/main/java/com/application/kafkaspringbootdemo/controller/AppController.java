package com.application.kafkaspringbootdemo.controller;
import com.application.kafkaspringbootdemo.model.PoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root/v1")
public class AppController {

    @Value("${kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, PoDetails> kafkaTemplate;
    @PostMapping("/data")
    public void home(@RequestBody PoDetails poDetails){
        StringBuilder sb = new StringBuilder();
        final ListenableFuture<SendResult<String, PoDetails>> producer = kafkaTemplate.send(topicName, poDetails);
        producer.addCallback(new ListenableFutureCallback<SendResult<String, PoDetails>>() {
            @Override
            public void onFailure(Throwable throwable) {
                sb.append(throwable.getMessage());
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, PoDetails> result) {
                System.out.println("Data successfully registered with Kafka Topic..");
                System.out.println("Partition -> "+result.getRecordMetadata().partition());
                System.out.println("Offset -> "+result.getRecordMetadata().offset());

            }
        });
    }

}



