package com.rslearning.employee.common.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LoggingAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeGetMethod(){
        System.out.println("Fetching Employee Record");
    }

    @After("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void afterPostMethod(){
        System.out.println("Modifications in Database expensive queries executed using PostMapping");
    }

    @Before("within(com.rslearning.employee.controller.EmployeeController)")
    public void commonforAllMethods(){
        System.out.println("Employee Controller Requested at : "+new Date());
    }
}
