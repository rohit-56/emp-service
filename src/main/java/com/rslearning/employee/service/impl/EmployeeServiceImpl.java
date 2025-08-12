package com.rslearning.employee.service.impl;

import com.rslearning.employee.common.mapper.EmployeeMapper;
import com.rslearning.employee.http.request.CreateEmployee;
import com.rslearning.employee.http.request.UpdateEmployee;
import com.rslearning.employee.http.response.EmployeeResponse;
import com.rslearning.employee.model.EmployeeEntity;
import com.rslearning.employee.repository.EmployeeRepository;
import com.rslearning.employee.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public EmployeeResponse registerEmployee(CreateEmployee createEmployee) {
        EmployeeEntity employee = EmployeeMapper.fromCreateEmployeeToEmployeeEntity.apply(createEmployee);
        EmployeeEntity createdEmployee = employeeRepository.save(employee);
        return EmployeeMapper.fromEmployeeEntityToEmployeeResponse.apply(createdEmployee);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);

        if(employee.get()==null){
           //handle exception here
        }
        return EmployeeMapper.fromEmployeeEntityToEmployeeResponse.apply(employee.get());
    }

    @Override
    public EmployeeResponse updateEmployeeDetails(UpdateEmployee updateEmployee) {
        EmployeeEntity employee = EmployeeMapper.fromUpdateEmployeeToEmployeeEntity.apply(updateEmployee);
        EmployeeEntity employeeEntity = employeeRepository.save(employee);
        return EmployeeMapper.fromEmployeeEntityToEmployeeResponse.apply(employeeEntity);
    }

    @Override
    public String deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return "Record Deleted";
    }

    @Override
    public EmployeeResponse getEmployeeByEmail(String email) {
        Optional<EmployeeEntity> employee = employeeRepository.findEmployeeByEmail(email);

        if(employee.get()==null){
            //handle exception here
        }
        return EmployeeMapper.fromEmployeeEntityToEmployeeResponse.apply(employee.get());
    }
}
