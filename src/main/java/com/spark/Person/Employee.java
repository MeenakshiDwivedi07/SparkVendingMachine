package com.spark.Person;

public class Employee implements Person {

    private String EmployeeId;

    public Employee(String employeeId) {
        EmployeeId = employeeId;

    }

    public String getEmployeeId() {
        return EmployeeId;
    }
}