package acme.business;

import acme.data.StudentRepository;

public class Student implements Comparable<Student> {
    // Private instance variables (fields) to store student data
    private String name; // Corresponds to __nome
    private double grade; // Corresponds to __nota (using double for potential decimal grades)

    // Constructor: Initializes the acme.business.Student object when it's created
    public Student(String name, double grade) {
        this.name = name; // 'this.name' refers to the instance variable, 'name' refers to the parameter
        this.grade = grade;
    }

    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }


    // Getter for 'name' (equivalent to Python's @property for 'nome')
    public String getName() {
        return name;
    }

    // Setter for 'name' (equivalent to Python's @nome.setter)
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'grade' (equivalent to Python's @property for 'nota')
    public double getGrade() {
        return grade;
    }

    // Setter for 'grade' (equivalent to Python's @nota.setter)
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
