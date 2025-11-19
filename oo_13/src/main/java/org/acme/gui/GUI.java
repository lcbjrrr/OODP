package org.acme.gui;

import org.acme.business.App;
import org.acme.business.IStudentRepository;
import org.acme.business.RepositoriesAbstractFactory;
import org.acme.business.Student;
import org.acme.business.exception.StudentAlreadyEnrolledExpection;

import java.util.List;

public class GUI {
    private App app;

    public GUI(RepositoriesAbstractFactory factory){
        app =  App.getInstance(factory.getStudentRepository());
    }

    public void run(){

        System.out.println("Adding students...");

        try {
            app.enrollStudent(new Student("Luiz", 5.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try {
            app.enrollStudent(new Student("Ze", 7.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            app.enrollStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            app.enrollStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}
        try{
            app.enrollStudent(new Student("Luiz", 1.0));
        } catch (StudentAlreadyEnrolledExpection e) {System.out.println("Student already enrolled");}

        System.out.println("\nInitial List (after adding, might have been resized):");
        printList(app.retrieveOrderedStudents());

        System.out.println("-------");
        double averageGrade = app.calculateClassAverage();

        System.out.println(averageGrade);

    }



    public void printList(List<Student> students) {
        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getGrade());
        }
    }
}
