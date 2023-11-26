package com.example.exam2.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {


 @NotEmpty(message = "id must not be empty")
 @Size(min = 5 ,max = 5 , message = "id must be 5 Digits ")
    private String id;



 @Pattern(regexp = "[^0-9]*", message = "name must not contain numbers")
 @NotEmpty(message = "name must not be empty")
    private String name;




@Positive(message = "the age most be number only")
//@NotEmpty(message = "age must not be empty")
    private int age;

    @Pattern(regexp = "[^0-9]*", message = "major must not contain numbers")
    @NotEmpty(message = "major must not be empty")
    private String major;
}
