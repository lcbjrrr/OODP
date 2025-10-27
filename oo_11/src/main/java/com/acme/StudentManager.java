package com.acme;

public class StudentManager {
    private IStudentRepository studentRepository;

    public StudentManager(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
}
