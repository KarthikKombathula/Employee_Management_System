package com.backend.ems_backend.mapper;

import com.backend.ems_backend.dtos.EmployeeDto;
import com.backend.ems_backend.entity.Employee;

public class EmployeeMapper
{
    public static EmployeeDto convertToEmployeeDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee convertToEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
