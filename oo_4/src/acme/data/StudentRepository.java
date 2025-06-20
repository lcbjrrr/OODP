package acme.data;
import acme.business.Student;
public interface StudentRepository {
    public void save(Student student);
    public Student findById(int id);
    public Student[] findAll();
    public int count();
}
