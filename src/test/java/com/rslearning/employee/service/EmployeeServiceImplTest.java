package com.rslearning.employee.service;

import com.rslearning.employee.http.request.CreateEmployee;
import com.rslearning.employee.http.response.EmployeeResponse;
import com.rslearning.employee.model.EmployeeEntity;
import com.rslearning.employee.repository.EmployeeRepository;
import com.rslearning.employee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerEmployeeTest(){
CreateEmployee createEmployee = new CreateEmployee("E001","Test","test@gmail.com","Tester","Testing");
EmployeeEntity savedEmployee = new EmployeeEntity(2L,"E001","Test","test@gmail.com","Tester","Testing");
when(employeeRepository.save(ArgumentMatchers.any())).thenReturn(savedEmployee);
EmployeeResponse employeeResponse = employeeService.registerEmployee(createEmployee);
        Assertions.assertNotNull(employeeResponse);
        Assertions.assertEquals(savedEmployee.getEmail(),employeeResponse.getEmail());
        Assertions.assertEquals(createEmployee.getDesignation(),employeeResponse.getDesignation());
    }

    @Test
    public void getEmployeeByIdTest(){
        EmployeeEntity employee=new EmployeeEntity(1L,"E0502","Rohit","rohit@gmail.com","Senior Developer","Backend");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        EmployeeResponse employeeResponse = employeeService.getEmployeeById(1L);
        Assertions.assertNotNull(employeeResponse);
        Assertions.assertEquals(employee.getEmail(),employeeResponse.getEmail());
    }

    @Disabled
    @Test
    public void updateEmployeeDetailsTest(){

    }

    @Disabled
    @Test
    public void deleteEmployeeByIdTest(){

    }

    @Disabled
    @Test
    public void getEmployeeByEmailTest(){

    }
}
