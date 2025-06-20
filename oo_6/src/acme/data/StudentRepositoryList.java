package acme.data;

import acme.business.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepositoryList implements StudentRepository {

    private LinkedList<Student> students;

    public StudentRepositoryList() {
        this.students = new LinkedList<>();
    }

    public void save(Student student){
        students.add(student);
    }
    public Student findById(Integer id){
        return students.get(id);
    }
    public List<Student> findAll(){
        return students ;

    }
    public Integer count(){
        return students.size();
    }

    public List<Student> findAllByOrderByName(){
        return students.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Student findByName(String name){
        Student student = null;
        for(Student s: students){
            if(s.getName().equals(name)){
                student = s;
            }
        }
        return student;
    }
}
