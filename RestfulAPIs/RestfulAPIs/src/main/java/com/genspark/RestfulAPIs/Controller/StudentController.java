package com.genspark.RestfulAPIs.Controller;

import com.genspark.RestfulAPIs.Entity.Student;
import com.genspark.RestfulAPIs.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @GetMapping("/")
    public List<Student> getAll(){
        return this.service.getAllStudents();
    }
    @GetMapping("/get/{id}")
    public Student getById(@PathVariable String id){
        return this.service.getStudentById(Integer.parseInt(id));
    }
    @PostMapping("/add")
    public Student addNewStudent(@RequestBody Student s){
        return this.service.addStudent(s);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student s){
        return this.service.updateStudent(s);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return this.service.deleteStudentById(Integer.parseInt(id));
    }
    @GetMapping("/filter")
    public List<Student> filter(@RequestParam(value="gpa",defaultValue = "0.0") String gpa){
        return this.service.filterStudents(Double.parseDouble(gpa));
    }

}
