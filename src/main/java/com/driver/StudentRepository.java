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
    Map<String,List<String>> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){
        studentDb.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDb.put(teacher.getName(),teacher);
        studentTeacherPair.put(teacher.getName(), new ArrayList<>());
    }
    public void addStudentTeacherPair(String student, String teacher){
        studentTeacherPair.get(teacher).add(student);
        Teacher teacher1 = teacherDb.get(teacher);
        teacher1.setNumberOfStudents(teacher1.getNumberOfStudents() + 1);
    }
    public Student getStudentByName(String name){
        return studentDb.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherDb.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentTeacherPair.get(teacher);
    }
    public List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for (Student student : studentDb.values()) {
            students.add(student.getName());
        }
        return students;
    }

    public void deleteTeacherByName(String name) {
        List<String> students = studentTeacherPair.get(name);
        for (String student : students) {
            studentDb.remove(student);
        }
        studentTeacherPair.remove(name);
        teacherDb.remove(name);
    }

    public void deleteAllTeachers() {
        for (String teacher : teacherDb.keySet()) {
            List<String> students = studentTeacherPair.get(teacher);
            for (String student : students) {
                studentDb.remove(student);
            }
        }
    }
}
