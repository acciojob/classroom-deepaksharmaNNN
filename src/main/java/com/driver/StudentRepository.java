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

    public List<String> getAllStudents() {
        // get all students from studentDb
        List<String> students = new ArrayList<>();
        for(Map.Entry<String, Student> entry : studentDb.entrySet()){
            students.add(entry.getKey());
        }
        return students;
    }
}
