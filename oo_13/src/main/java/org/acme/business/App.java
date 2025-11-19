package org.acme.business;


import org.acme.business.exception.StudentAlreadyEnrolledExpection;

import java.util.List;

 public class App {
    private static App instance;
    private final StudentManager studentManager;

    public static App getInstance(IStudentRepository studentRepo) {
        if (instance == null) {
            instance = new App(studentRepo);
        }
        return instance;
    }

    private App(IStudentRepository studentRepo) {
        this.studentManager = new StudentManager(studentRepo);
    }


    public void enrollStudent(Student student) throws StudentAlreadyEnrolledExpection {
        studentManager.addStudent(student);
    }

    public Student fetchStudent(int position) {
        return studentManager.getStudent(position);
    }


    public boolean checkEnrollmentStatus(String studentName) {
        return studentManager.isAlreadyEnrolled(studentName);
    }

    public double calculateClassAverage() {
        return studentManager.calculateAverage();
    }


    public List<Student> retrieveOrderedStudents() {
        return studentManager.getOrderedStudents();
    }
}
