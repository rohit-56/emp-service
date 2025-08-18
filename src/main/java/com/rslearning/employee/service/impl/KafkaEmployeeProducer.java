package com.rslearning.employee.service.impl;

import com.rslearning.employee.http.response.EmployeeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaEmployeeProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEmployeeProducer.class);

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendEmployeeDetailsToConsumerService(EmployeeResponse employeeResponse){
        LOGGER.info(String.format("Message sent for employee -> %s", employeeResponse.empName));
        kafkaTemplate.send("emp-service-topic",employeeResponse);
    }

}
