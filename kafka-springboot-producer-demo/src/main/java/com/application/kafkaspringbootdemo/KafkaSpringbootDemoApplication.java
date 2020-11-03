package com.application.kafkaspringbootdemo;

import com.application.kafkaspringbootdemo.model.PoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class KafkaSpringbootDemoApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(KafkaSpringbootDemoApplication.class, args);
	}

}
