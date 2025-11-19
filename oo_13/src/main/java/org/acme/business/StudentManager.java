package org.acme.business;

import org.acme.business.exception.StudentAlreadyEnrolledExpection;

import java.util.List;
public class StudentManager  {
    private IStudentRepository repository;
    public StudentManager(IStudentRepository repository) {
        this.repository=repository;
    }
    public void addStudent(Student student) throws StudentAlreadyEnrolledExpection {
        if (!isAlreadyEnrolled(student.getName())) {
            repository.save(student);
        }else throw new StudentAlreadyEnrolledExpection(student);
    }
    public Student getStudent(int position) {
        //return repository.findById(position).orElse(new Student());
        return repository.findById(position);
    }
    public double calculateAverage() {
        double totalGrade = 0;
        for (int i = 0; i < repository.count(); i++) {
            totalGrade = totalGrade+ this.getStudent(i).getGrade();
        }
        return totalGrade / repository.count();
    }
    public List<Student> getOrderedStudents(){
        return repository.findAllByOrderByName();
    }
    public boolean isAlreadyEnrolled(String studentName) {
        Student student= repository.findByName(studentName);
        if (student == null) {
            return false;
        }else {
            return true;
        }
    }



}