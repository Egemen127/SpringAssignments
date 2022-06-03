package com.genspark.RestfulAPIs.Service;

import com.genspark.RestfulAPIs.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student addStudent(Student s);
    Student updateStudent(Student s);
    String deleteStudentById(int id);
    List<Student> filterStudents(double gpa);
}
