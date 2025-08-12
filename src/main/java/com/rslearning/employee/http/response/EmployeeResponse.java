package com.rslearning.employee.http.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

    public Long Id;

    public String empCode;

    public String empName;

    public String email;

    public String designation;

    public String department;
}
