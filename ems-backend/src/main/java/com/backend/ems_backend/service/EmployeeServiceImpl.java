package com.backend.ems_backend.service;

import com.backend.ems_backend.dtos.EmployeeDto;
import com.backend.ems_backend.entity.Employee;
import com.backend.ems_backend.exceptions.EmployeeNotFoundException;
import com.backend.ems_backend.mapper.EmployeeMapper;
import com.backend.ems_backend.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.convertToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.convertToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with id: " + id)
        );

        return EmployeeMapper.convertToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().
                map(employee -> EmployeeMapper.convertToEmployeeDto(employee))
                .toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee= employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with id: " + id)
        );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.convertToEmployeeDto(updatedEmployee);

    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found with id: " + id)
        );
        employeeRepository.delete(employee);
    }
}
