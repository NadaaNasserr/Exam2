package com.example.exam2.Service;


import com.example.exam2.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@Service
public class StudentService {


    ArrayList<Student> students = new ArrayList<>();


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){

     students.add(student);
        }
        public boolean updateStudent(String id, Student student){

            for (int i = 0; i <students.size() ; i++) {
                if(students.get(i).getId().equals(id)){
                    students.set(i,student);
                    return true;
                }

            }
            return false;
    }

    public boolean deleteStudent(String id){

        for (int i = 0; i <students.size() ; i++) {
if(students.get(i).getId().equals(id)){
    students.remove(i);
    return true;
}
        }
        return false;
    }
    public Student oneStudent(String name){

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().equals(name)){
                return students.get(i);
            }

        }
        return null;
    }
}



