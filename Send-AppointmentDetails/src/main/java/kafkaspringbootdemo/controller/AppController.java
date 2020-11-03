package kafkaspringbootdemo.controller;

import kafkaspringbootdemo.model.AppointmentScheduling;
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
@RequestMapping("/sendinfo")
public class AppController {

    @Value("${kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, AppointmentScheduling> kafkaTemplate;
    
    @PostMapping("/data")
    public void home(@RequestBody AppointmentScheduling user){
        StringBuilder sb = new StringBuilder();
        final ListenableFuture<SendResult<String, AppointmentScheduling>> producer = kafkaTemplate.send(topicName, user);
        producer.addCallback(new ListenableFutureCallback<SendResult<String, AppointmentScheduling>>() {
            @Override
            public void onFailure(Throwable throwable) {
                sb.append(throwable.getMessage());
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, AppointmentScheduling> result) {
                System.out.println("Data successfully registered with Kafka Topic..");
                System.out.println("Partition -> "+result.getRecordMetadata().partition());
                System.out.println("Offset -> "+result.getRecordMetadata().offset());
            }
        });
    }

}
