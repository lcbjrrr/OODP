package acme.business;
import acme.business.exceptions.StudentAlreadyEnrolledException;
import acme.data.StudentRepository;

import java.util.List;

public class StudentManager {
    private StudentRepository students;
    // Constructor: Initializes the array with a specified initial capacity
    public StudentManager(StudentRepository students) {
         this.students = students ;
    }



    // Adds a acme.business.Student object to the registry
    public void addStudent(Student student) throws StudentAlreadyEnrolledException {
        if(!isAlreadyEnrolled(student.getName()) ){
            students.save(student);
        }else{
            throw new StudentAlreadyEnrolledException(student.getName());
        }

    }

    public boolean isAlreadyEnrolled(String studentName) {
        Student student= students.findByName(studentName);
        if (student == null) {
            return false;
        }else {
            return true;
        }
    }

    Student findByName(String name) {
        return students.findByName(name);
    }

    // Gets a acme.business.Student object at a specific position
    public Student getStudent(int position){
        return students.findById(position);
    }

    // Sorts students by grade (using bubble sort) and calculates the average grade
    public double calculateAverage() {
        double totalGrade = 0;
        for (int i = 0; i < students.count(); i++) {
            totalGrade = totalGrade+ students.findById(i).getGrade(); // Sum grades while iterating
        }
        return totalGrade / students.count();
    }
    public List<Student> getOrderedStudents(){
        return students.findAll();
    }
    public int getStudentCount() {
        return students.count();
    }
}


