package acme.gui;
import acme.business.*;
import acme.business.exceptions.StudentAlreadyEnrolledException;
import acme.data.StudentRepositoryArray;
import acme.data.StudentRepositoryList;

import java.util.List;

public class GUI {

    // Prints the list of students (name: grade)
    public static void printList(List<Student> students ) {
        // Iterate only up to studentCount
        for (Student student : students) {
            System.out.println(student.getName() + " : " + student.getGrade());
        }
    }

    // --- Main method for demonstrating the functionality ---
    public static void main(String[] args) {
        // Create an instance with an initial capacity (e.g., 3 to see resizing happen early)
        StudentManager school = new StudentManager(new StudentRepositoryList());

        System.out.println("Adding students...");
        try {school.addStudent(new Student("Luiz", 5.0));
        }catch (StudentAlreadyEnrolledException e){System.out.println(e.getName()+" already enrolled!");}
        try{school.addStudent(new Student("Luiz", 7.0));
        }catch (StudentAlreadyEnrolledException e){System.out.println(e.getName()+" already enrolled!");}
        try{school.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        }catch (StudentAlreadyEnrolledException e){System.out.println(e.getName()+" already enrolled!");}
        try{school.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        }catch (StudentAlreadyEnrolledException e){System.out.println(e.getName()+" already enrolled!");}
        try{school.addStudent(new Student("Joao", 1.0));
        }catch (StudentAlreadyEnrolledException e){System.out.println(e.getName()+" already enrolled!");}

        System.out.println("\nInitial List (after adding, might have been resized):");
        printList(school.getOrderedStudents() );

        System.out.println("-------");

        // Sort students and calculate the average grade
        double averageGrade = school.calculateAverage();


        printList(school.getOrderedStudents() );
        System.out.println(averageGrade);


    }
}
