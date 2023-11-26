package com.example.exam2.Controller;



import com.example.exam2.Model.Teacher;
import com.example.exam2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;



    @GetMapping("/get")
    public ResponseEntity getTeacher(){

        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacher());
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("teacher added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @Valid @RequestBody Teacher teacher, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isupdated = teacherService.updateTeacher(id,teacher);
        if(isupdated){
            return ResponseEntity.status(HttpStatus.OK).body("teacher updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){

        boolean isupdated = teacherService.deleteTeacher(id);
        if(isupdated){
            return ResponseEntity.status(HttpStatus.OK).body("teacher deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid id");
    }


    @GetMapping("/oneTeacher/{id}")
    public ResponseEntity getOneTeacher(@PathVariable String id){

        if(teacherService.oneTeacher(id) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");


        }
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.oneTeacher(id));
    }
}





