package com.backend.ems_backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto
{
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
