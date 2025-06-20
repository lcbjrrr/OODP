import java.util.Scanner;

public class StudentManager {
    private Student[] students; // The fixed-size array to store students
    private int studentCount;   // Tracks the actual number of students added

    // Constructor: Initializes the array with a specified initial capacity
    public StudentManager(int initialCapacity) {
        this.students = new Student[initialCapacity];
        this.studentCount = 0;
    }



    // Adds a Student object to the registry
    public void addStudent(Student student) {
        this.students[studentCount] = student;
        studentCount++; // Increment the count of actual students
    }

    // Gets a Student object at a specific position
    public Student getStudent(int position) {
        return this.students[position];
    }

    // Sorts students by grade (using bubble sort) and calculates the average grade
    public double calculateAverage() {
        double totalGrade = 0;
        for (int i = 0; i < studentCount; i++) {
            totalGrade = totalGrade+ this.students[i].getGrade(); // Sum grades while iterating
        }
        return totalGrade / studentCount;
    }



    public Student[] getOrderedStudents(){
        return this.students;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    // Prints the list of students (name: grade)
    public void printList() {
        // Iterate only up to studentCount
        for (int i = 0; i < studentCount; i++) {
            System.out.println(this.students[i].getName() + " : " + this.students[i].getGrade());
        }
    }

    public static void mainz(String[] args) {
        Guy[] guys = new Guy[5];
        int count = 0;
        System.out.println("Adding guys: type -1 to exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter " + name + " cash $: ");
        float cash = scanner.nextFloat();
        scanner.nextLine();
        while (cash>=0) {
            guys[count] = new Guy(name, cash);
            System.out.print("Enter student name: ");
            name = scanner.nextLine();
            System.out.print("Enter " + name + " cash $: ");
            cash = scanner.nextFloat();
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        StudentManager school = new StudentManager(10);
        System.out.println("Adding students: type -1 to exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter " + name + " Grade: ");
        Double grade = scanner.nextDouble();
        scanner.nextLine();
        while (grade>=0) {
            school.addStudent(new Student(name, grade));
            System.out.print("Enter student name: ");
            name = scanner.nextLine();
            System.out.print("Enter " + name + " Grade: ");
            grade = scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println("\nInitial List:");
        school.printList();
        System.out.println("-------");
        double averageGrade = school.calculateAverage();
        System.out.println(averageGrade);
    }
    // --- Main method for demonstrating the functionality ---
    public static void mainx(String[] args) {
        // Create an instance with an initial capacity (e.g., 3 to see resizing happen early)
        StudentManager school = new StudentManager(10);

        System.out.println("Adding students...");
        school.addStudent(new Student("Luiz", 5.0));
        school.addStudent(new Student("Ze", 7.0));
        school.addStudent(new Student("Mane", 3.0)); // This might trigger a resize if initial capacity was 3
        school.addStudent(new Student("Maria", 2.0)); // This will trigger a resize if initial capacity was 3
        school.addStudent(new Student("Joao", 1.0));

        System.out.println("\nInitial List (after adding, might have been resized):");
        school.printList();

        System.out.println("-------");

        // Sort students and calculate the average grade
        double averageGrade = school.calculateAverage();


        school.printList();
        System.out.println(averageGrade);

        Student[] students = school.getOrderedStudents();
        for (int i = 0; i < school.getStudentCount(); i++) {
            System.out.println(students[i].getName() + " : " );
        }
    }
}


