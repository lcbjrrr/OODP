package acme.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryDB implements acme.data.StudentRepository {

    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:students.db"; // Database file name

    public StudentRepositoryDB() {
        try {
            Class.forName(JDBC_DRIVER);
            createStudentsTable();
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC driver not found: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void createStudentsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "grade TEXT" +    // Assuming Student has a grade field
                ");";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Students table created or already exists.");
        } catch (SQLException e) {
            System.err.println("Error creating Students table: " + e.getMessage());
        }
    }

    public void save(acme.business.Student student){
        String sql = "INSERT INTO Students(name,  grade) VALUES(?,?)"; // Assuming age and grade
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setDouble(2, student.getGrade()); // Assuming getGrade() method in Student
            pstmt.executeUpdate();
            System.out.println("Student added: " + student.getName());
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }

    }
    public acme.business.Student findById(Integer id){
        String sql = "SELECT id, name, grade FROM Students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id+1);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new acme.business.Student( rs.getString("name"), rs.getDouble("grade"));
            }
        } catch (SQLException e) {
            System.err.println("Error getting student by ID: " + e.getMessage());
        }
        return null;
    }
    public List<acme.business.Student> findAll(){
        List<acme.business.Student> students = new ArrayList<>();
        String sql = "SELECT id, name, grade FROM Students ORDER BY name ASC";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new acme.business.Student( rs.getString("name"), rs.getDouble("grade")));
            }
        } catch (SQLException e) {
            System.err.println("Error getting all students: " + e.getMessage());
        }
        return students;
    }
    public Integer count(){
        String sql = "SELECT COUNT(*) AS count FROM Students";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (SQLException e) {
            System.err.println("Error getting student count: " + e.getMessage());
        }
        return 0;
    }
    public List<acme.business.Student> findAllByOrderByName(){
        //TODO
        return findAll();
    }
    public acme.business.Student findByName(String name){
        String sql = "SELECT id, name, grade FROM Students WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new acme.business.Student(  rs.getString("name"),  rs.getDouble("grade"));
            }
        } catch (SQLException e) {
            System.err.println("Error finding student by name: " + e.getMessage());
        }
        return null;
    }
}
