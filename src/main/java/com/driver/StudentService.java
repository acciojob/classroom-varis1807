package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void createStudentTeacherPair(String student, String teacher) {
        studentRepository.createStudentTeacherPair(student, teacher);
    }

    public Student findStudent(String name) {
        return studentRepository.findStudent(name);
    }
    public Teacher findTeacher(String name) {
        return studentRepository.findTeacher(name);
    }


    public List<String> findStudentFromTeacher(String teacher) {
        return studentRepository.findStudentFromTeacher(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
