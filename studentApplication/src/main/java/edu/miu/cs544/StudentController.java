package edu.miu.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = {"/home/student"})
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/list"})
    public List<Student> displayStudents(){
       return  studentService.getAll();
    }

    @PostMapping(value = {"/register"})
    public void RegisterStudents(@Valid @RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping(value = {"/get/{studentId}"})
    public Student GetStudent(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }

    @PutMapping(value = {"update/{studentId}"})
    public void updateStudent( @PathVariable Integer studentId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email){
         studentService.update(studentId,name,email);
    }

    @DeleteMapping(value = {"/delete/{studentId}"})
    public void deleteStudent(@PathVariable Integer studentId){
        studentService.deleteStudentById(studentId);
    }

}