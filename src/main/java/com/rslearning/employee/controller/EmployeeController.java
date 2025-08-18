package com.rslearning.employee.controller;

import com.rslearning.employee.http.request.CreateEmployee;
import com.rslearning.employee.http.request.UpdateEmployee;
import com.rslearning.employee.http.response.EmployeeResponse;
import com.rslearning.employee.service.IEmployeeService;
import com.rslearning.employee.service.impl.KafkaEmployeeProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private IEmployeeService employeeService;
    private KafkaEmployeeProducer kafkaEmployeeProducer;

    public EmployeeController(IEmployeeService employeeService,KafkaEmployeeProducer kafkaEmployeeProducer){
        this.employeeService=employeeService;
        this.kafkaEmployeeProducer=kafkaEmployeeProducer;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> createEmployeeRecord(@RequestBody CreateEmployee createEmployee){
        EmployeeResponse employeeResponse = employeeService.registerEmployee(createEmployee);
        kafkaEmployeeProducer.sendEmployeeDetailsToConsumerService(employeeResponse);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get/employee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeRecordById(@PathVariable("id") Long id){
       EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponse> updateEmployeeRecord(@RequestBody UpdateEmployee updateEmployee){
      EmployeeResponse employeeResponse = employeeService.updateEmployeeDetails(updateEmployee);
      return new ResponseEntity<>(employeeResponse,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeRecord(@PathVariable("id") Long id){
       String response = employeeService.deleteEmployeeById(id);
       return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get/employee")
    public ResponseEntity<EmployeeResponse> getEmployeeRecordByEmail(@RequestParam String email){
     EmployeeResponse employeeResponse=employeeService.getEmployeeByEmail(email);
        return new ResponseEntity<>(employeeResponse, HttpStatus.ACCEPTED);
    }
}
