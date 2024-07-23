package org.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student{
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String city;
    private String religion;
    private String gender;
    private String email;
    private String phoneNumber;
    private String postalCode;
    private String zipCode;
}