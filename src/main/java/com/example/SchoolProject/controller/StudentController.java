package com.example.SchoolProject.controller;

import com.example.SchoolProject.entity.Student;
import com.example.SchoolProject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/new/api/students1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    //public String saveStudent(@RequestBody Student student) {
    //   String result = studentService.saveStudent(student);
    //  return result;

    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        String result = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
        // @GetMapping
        //     public ResponseEntity<List<Student>> getAllStudent(){;
        //      return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());

    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudentList() {
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long sid) throws Exception {
        return ResponseEntity.ok(studentService.getStudentById(sid));
    }

    //URL: http://localhost:8083/new/api/students1
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePartialStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updatePartialStudent(id, student));
    }

    //URL: http://localhost:8083/new/api/students1/bulk
    @PostMapping("/bulk")
    public ResponseEntity<String> savebulkstudent(@RequestBody List<Student> students){
        return ResponseEntity.ok(studentService.saveBulkStudent(students));
    }
}




