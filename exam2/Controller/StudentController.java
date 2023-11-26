package com.example.exam2.Controller;


import com.example.exam2.Model.Student;
import com.example.exam2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor

public class StudentController {

    private final StudentService studentService;



    @GetMapping("/get")
    public ResponseEntity getStudent(){

        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }


    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("Student added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @Valid @RequestBody Student student, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isupdated = studentService.updateStudent(id,student);
        if(isupdated){
            return ResponseEntity.status(HttpStatus.OK).body("Student updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){

        boolean isupdated = studentService.deleteStudent(id);
        if(isupdated){
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid id");
    }


    @GetMapping("/oneStudent/{name}")
    public ResponseEntity oneStudent(@PathVariable String name){

        if(studentService.oneStudent(name) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("name not found");

        }
        return ResponseEntity.status(HttpStatus.OK).body(studentService.oneStudent(name));
    }
    }



