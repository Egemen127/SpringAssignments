package com.genspark.RestfulAPIs.Service;

import com.genspark.RestfulAPIs.Dao.StudentDao;
import com.genspark.RestfulAPIs.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentDao studentdao;
    @Override
    public List<Student> getAllStudents() {
        return this.studentdao.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Student s0;
        Optional<Student> s = this.studentdao.findById(id);
        if(s.isPresent()){
            s0 = s.get();
        } else
        { throw new RuntimeException("Student not found for id :: "+id);}
        return s0;
    }

    @Override
    public Student addStudent(Student s) {
        return this.studentdao.save(s);
    }

    @Override
    public Student updateStudent(Student s) {
        return this.studentdao.save(s);
    }

    @Override
    public String deleteStudentById(int id) {
        this.studentdao.deleteById(id);
        return "Student deleted!!";
    }

    @Override
    public List<Student> filterStudents(double gpa) {
        return this.studentdao.findAll().stream().filter(e->e.getGPA()>gpa).collect(Collectors.toList());
    }
}
