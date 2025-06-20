package acme.data;

import acme.business.Student;

import java.util.Arrays;
import java.util.List;

public class StudentRepositoryArray implements StudentRepository {

    private Student[] students; // The fixed-size array to store students
    private int studentCount;   // Tracks the actual number of students added

    public StudentRepositoryArray(int size){
        students = new Student[size];
        studentCount = 0;
    }

    public Student findByName(String name){
        return null;
    }

    public void save(Student student){
        students[studentCount] = student;
        studentCount++;
    }
    public Student findById(Integer id){
        return students[id];
    }
    public List<Student> findAll(){
        //System.out.println(students);
        return List.of(Arrays.copyOfRange(students, 0, studentCount-1));
    }
    public List<Student> findAllByOrderByName(){
        return this.findAll();
    }

    public Integer count(){
        return studentCount;
    }

}
