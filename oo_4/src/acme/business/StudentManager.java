package acme.business;
import acme.data.StudentRepository;
public class StudentManager {
    private StudentRepository students;
    // Constructor: Initializes the array with a specified initial capacity
    public StudentManager(StudentRepository students) {
         this.students = students ;
    }



    // Adds a acme.business.Student object to the registry
    public void addStudent(Student student) {
         students.save(student);
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
    public Student[] getOrderedStudents(){
        return students.findAll();
    }
    public int getStudentCount() {
        return students.count();
    }
}


