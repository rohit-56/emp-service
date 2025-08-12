package com.rslearning.employee.service;


import com.rslearning.employee.http.request.CreateEmployee;
import com.rslearning.employee.http.request.UpdateEmployee;
import com.rslearning.employee.http.response.EmployeeResponse;

public interface IEmployeeService {

   EmployeeResponse registerEmployee(CreateEmployee createEmployee);

   EmployeeResponse getEmployeeById(Long Id);

   EmployeeResponse updateEmployeeDetails(UpdateEmployee updateEmployee);

   String deleteEmployeeById(Long Id);

   EmployeeResponse getEmployeeByEmail(String email);

}
