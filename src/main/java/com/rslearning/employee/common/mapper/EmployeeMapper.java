package com.rslearning.employee.common.mapper;

import com.rslearning.employee.http.request.CreateEmployee;
import com.rslearning.employee.http.request.UpdateEmployee;
import com.rslearning.employee.http.response.EmployeeResponse;
import com.rslearning.employee.model.EmployeeEntity;

import java.util.function.Function;

public class EmployeeMapper {

    public static final Function<CreateEmployee, EmployeeEntity> fromCreateEmployeeToEmployeeEntity =
    createEmployee -> {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmpCode(createEmployee.getEmpCode());
        employee.setEmpName(createEmployee.getEmpName());
        employee.setEmail(createEmployee.getEmail());
        employee.setDesignation(createEmployee.getDesignation());
        employee.setDepartment(createEmployee.getDepartment());
        return employee;
    };

    public static final Function<UpdateEmployee, EmployeeEntity> fromUpdateEmployeeToEmployeeEntity =
            updateEmployee -> {
                EmployeeEntity employee = new EmployeeEntity();
                employee.setId(updateEmployee.getId());
                employee.setEmpCode(updateEmployee.getEmpCode());
                employee.setEmpName(updateEmployee.getEmpName());
                employee.setEmail(updateEmployee.getEmail());
                employee.setDesignation(updateEmployee.getDesignation());
                employee.setDepartment(updateEmployee.getDepartment());
                return employee;
            };

    public static final Function<EmployeeEntity, EmployeeResponse> fromEmployeeEntityToEmployeeResponse=
            employeeEntity -> {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        employeeResponse.setEmpName(employeeEntity.getEmpName());
        employeeResponse.setEmpCode(employeeEntity.getEmpCode());
        employeeResponse.setEmail(employeeEntity.getEmail());
        employeeResponse.setDesignation(employeeEntity.getDesignation());
        employeeResponse.setDepartment(employeeEntity.getDepartment());
        return employeeResponse;
            };


}
