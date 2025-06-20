package org.acme.oo_101;

import org.acme.business.Student;
import org.acme.business.StudentManager;
import org.acme.business.exception.StudentAlreadyEnrolledExpection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")

public class Oo101Application implements CommandLineRunner {
    private final StudentManager studentManager;
    @Autowired
    public Oo101Application(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public static void main(String[] args) {

        SpringApplication.run(Oo101Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Adding students...");

        try {
            studentManager.addStudent(new Student("Luiz", 5.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try {
            studentManager.addStudent(new Student("Ze", 7.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            studentManager.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            studentManager.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            studentManager.addStudent(new Student("Luiz", 1.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}

        System.out.println("\nInitial List (after adding, might have been resized):");
        printList(studentManager.getOrderedStudents());

        System.out.println("-------");
        double averageGrade = studentManager.calculateAverage();

        System.out.println(averageGrade);
    }

    static public void printList(List<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getGrade());
        }
    }
}
