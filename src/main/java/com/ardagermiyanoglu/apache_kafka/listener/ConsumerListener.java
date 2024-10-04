package com.ardagermiyanoglu.apache_kafka.listener;

import com.ardagermiyanoglu.apache_kafka.dto.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(ConsumerRecord<String, Event> payload){

        System.out.println(payload.value());
    }
}
