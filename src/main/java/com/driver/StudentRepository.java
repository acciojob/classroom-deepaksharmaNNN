package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<String,Student> studentDb = new HashMap<>();
    Map<String,Teacher> teacherDb = new HashMap<>();

    public void addStudent(Student student){
        studentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
    }
    public Student getStudentByName(String name){
        return studentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherDb.get(name);
    }

    public List<String> getAllStudents() {
        // get all students from studentDb
        List<String> students = new ArrayList<>();
        for(Map.Entry<String, Student> entry : studentDb.entrySet()){
            students.add(entry.getKey());
        }
        return students;
    }

}
