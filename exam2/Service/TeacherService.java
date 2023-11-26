package com.example.exam2.Service;


import com.example.exam2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList<Teacher> getTeacher() {
        return teachers;
    }

    public void addTeacher(Teacher student){

        teachers.add(student);
    }
    public boolean updateTeacher(String id, Teacher teacher){

        for (int i = 0; i <teachers.size() ; i++) {
            if(teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }

        }
        return false;
    }

    public boolean deleteTeacher(String id){

        for (int i = 0; i <teachers.size() ; i++) {
            if(teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public Teacher oneTeacher(String id){

        for (int i = 0; i < teachers.size(); i++) {
            if(teachers.get(i).getId().equals(id)){
                return teachers.get(i);
            }

        }
        return null;
    }
}


