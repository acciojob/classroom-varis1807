package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public class StudentRepository {
    // Creating databases
    private HashMap<String, Student> studentMap;

    private HashMap<String, Teacher> teacherMap;

    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }


    public void createStudentTeacherPair(String student, String teacher) {
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            studentMap.put(student, studentMap.get(student));
            teacherMap.put(teacher, teacherMap.get(teacher));
            List<String> currentStudent = new ArrayList<>();
            if(teacherStudentMapping.containsKey(teacher)) currentStudent = teacherStudentMapping.get(teacher);
            currentStudent.add(student);
            teacherStudentMapping.put(teacher, currentStudent);
        }
    }

    public Student findStudent(String name) {
        return studentMap.get(name);
    }

    public Teacher findTeacher(String name) {
        return teacherMap.get(name);
    }

    public List<String> findStudentFromTeacher(String teacher) {
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher))
            studentList = teacherStudentMapping.get(teacher);
        return studentList;
    }

    public List<String> findAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher) {
        List<String> students = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)){
            students = teacherStudentMapping.get(teacher);
            for(String student : students){
                if(studentMap.containsKey(student))
                    studentMap.remove(student);
            }
            teacherStudentMapping.remove(teacher);
        }

        if(teacherMap.containsKey(teacher));
    }
    public void deleteAllTeachers() {
        HashSet<String> studentSet = new HashSet<>();

        for(String teacher: teacherStudentMapping.keySet()){
            for(String student: teacherStudentMapping.get(teacher))
                studentSet.add(student);
        }

        for(String student: studentSet){
            if(studentMap.containsKey(student))
                studentSet.remove(student);
        }
    }
}
