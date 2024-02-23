package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.studentDb.put(student.getName(),student);
    }


    public void addTeacher(Teacher teacher) {
        studentRepository.teacherDb.put(teacher.getName(),teacher);
    }
    public Student getStudentByName(String name){
        return studentRepository.studentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return studentRepository.teacherDb.get(name);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
}
