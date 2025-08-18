package com.rslearning.employee.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;


@EnableKafka
public class KafkaConfig {

    @Bean
    public NewTopic createEmployeeTopic(){
        return TopicBuilder.name("emp-service-topic").build();
    }

}
