package acme.gui;
import acme.business.*;
import acme.data.StudentRepositoryArray;

public class GUI {

    // Prints the list of students (name: grade)
    public static void printList(Student[] students, int studentCount ) {
        // Iterate only up to studentCount
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].getName() + " : " + students[i].getGrade());
        }
    }

    // --- Main method for demonstrating the functionality ---
    public static void main(String[] args) {
        // Create an instance with an initial capacity (e.g., 3 to see resizing happen early)
        StudentManager school = new StudentManager(new StudentRepositoryArray(10));

        System.out.println("Adding students...");
        school.addStudent(new Student("Luiz", 5.0));
        school.addStudent(new Student("Ze", 7.0));
        school.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        school.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        school.addStudent(new Student("Joao", 1.0));

        System.out.println("\nInitial List (after adding, might have been resized):");
        printList(school.getOrderedStudents(),school.getStudentCount());

        System.out.println("-------");

        // Sort students and calculate the average grade
        double averageGrade = school.calculateAverage();


        printList(school.getOrderedStudents(),school.getStudentCount());
        System.out.println(averageGrade);


    }
}
