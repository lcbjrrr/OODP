package acme.data;
import acme.business.Student;

import java.util.List;

public interface StudentRepository {
    public void save(Student student);
    public Student findById(Integer id);
    public List<Student> findAll();
    public Integer count();
    public List<Student> findAllByOrderByName();
    public Student findByName(String name);
}
