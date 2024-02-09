package com.example.SchoolProject.service;

import com.example.SchoolProject.entity.Student;
import com.example.SchoolProject.repository.StudentRepository;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String saveStudent(Student student) {
        //  System.out.println(student);
        studentRepository.save(student);
        return "Student saved succesfully using repository";

    }

    public String deleteStudent(Long id) {
        //checking if student having id exists or not
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student deleted successfully!";
        }

        throw new ResourceNotFoundException("Student not found with id " + id);

    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new Exception("Student having id" + id + " not found!");
    }

    public String updateStudent(Long id, Student student){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exists"));
        existingStudent.setFullName(student.getFullName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setGender(student.getGender());
        existingStudent.setMajor(student.getMajor());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setEmail(student.getEmail());
        studentRepository.save(existingStudent);
        return "Student updated succesfully";

    }

    public String updatePartialStudent(Long id, Student student ){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student does not exist"));
        if(student.getFullName() != null) {
            existingStudent.setFullName(student.getFullName());
        }

        if(student.getAddress() != null) {
            existingStudent.setAddress(student.getAddress());
        }
        if(student.getGender() != null) {
            existingStudent.setGender(student.getGender());
        }

        if(student.getMajor() != null) {
            existingStudent.setMajor(student.getMajor());

        }

        if(student.getPhoneNumber() != null) {
            existingStudent.setPhoneNumber(student.getPhoneNumber());
        }

        if(student.getEmail() != null) {
            existingStudent.setEmail(student.getEmail());



        }studentRepository.save(existingStudent);
        return "Student Partially updated succesfully";
    }

    public String saveBulkStudent(List<Student> students) {
        studentRepository.saveAll(students);
        return "Student saved succesfully";
    }

}

