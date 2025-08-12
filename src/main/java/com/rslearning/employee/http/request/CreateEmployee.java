package com.rslearning.employee.http.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class CreateEmployee {

    public String empCode;

    public String empName;

    public String email;

    public String designation;

    public String department;
}
