package acme.data;

import acme.business.Student;

public class StudentRepositoryArray implements StudentRepository {

    private Student[] students; // The fixed-size array to store students
    private int studentCount;   // Tracks the actual number of students added

    public StudentRepositoryArray(int size){
        students = new Student[size];
        studentCount = 0;
    }

    public void save(Student student){
        students[studentCount] = student;
        studentCount++;
    }
    public Student findById(int id){
        return students[id];
    }
    public Student[] findAll(){
        return students;
    }
    public int count(){
        return studentCount;
    }

}
