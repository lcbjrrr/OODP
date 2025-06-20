package acme.gui;
import acme.business.*;
import acme.business.exceptions.StudentAlreadyEnrolledException;
import acme.data.StudentRepositoryDB;
import acme.data.StudentRepositoryList;
import acme.integration.FBIExternalPartnerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GUI {
    private StudentManager school;

    @Autowired
    public GUI(StudentManager school) {
        this.school = school;
    }

    public static void printList(List<Student> students ) {
        // Iterate only up to studentCount
        for (Student student : students) {
            System.out.println(student.getName() + " : " + student.getGrade());
        }
    }

    // --- Main method for demonstrating the functionality ---
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        GUI gui = context.getBean(GUI.class);
        gui.run();
    }
    public void run(){

        // Create an instance with an initial capacity (e.g., 3 to see resizing happen early)
        //StudentManager school = new StudentManager(new StudentRepositoryDB(),new FBIExternalPartnerAPI());

        System.out.println("Adding students...");
        try {school.addStudent(new Student("Luiz", 5.0));
        }catch (StudentAlreadyEnrolledException e){System.out.println(e.getName()+" already enrolled!");}
        try{school.addStudent(new Student("Ze", 7.0));
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
        System.out.println("Enrolling partner students...");

        try {school.enrollStudentsFromPartner();
        } catch (StudentAlreadyEnrolledException e) {System.out.println(e.getName()+" already enrolled!");}
        printList(school.getOrderedStudents() );



    }
}
