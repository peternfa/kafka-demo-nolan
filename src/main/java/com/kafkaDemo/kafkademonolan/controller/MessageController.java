package com.kafkaDemo.kafkademonolan.controller;

import com.kafkaDemo.kafkademonolan.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=i see you
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message Sent to the Topic");
    }

}


