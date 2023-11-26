package com.example.exam2.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class Teacher {

    @NotEmpty(message = "id must not be empty")
    @Size(min = 5 ,max = 5 , message = "id must be 5 Digits ")
    private String id;

    @Pattern(regexp = "[^0-9]*", message = "name must not contain numbers")
    @NotEmpty(message = "name must not be empty")
    private String name;



  //  @NotEmpty(message = "salary must not be empty")
    @Positive(message = "salary must be number")
    private  double salary;










}
