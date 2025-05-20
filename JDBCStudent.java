import java.sql.*;

public class JDBCStudent {
    // Database credentials
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {

            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");

            // Create table
            createTable(conn);

            // Insert student records
            insertStudent(conn, 1, "John Doe", "Computer Science");
            insertStudent(conn, 2, "Jane Smith", "Mathematics");

            // Retrieve student records
            selectStudents(conn);

            // Update student record
            updateStudent(conn, 1, "Information Technology");

            // Delete student record
            deleteStudent(conn, 2);

            // Close connection
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(100), department VARCHAR(100))";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created successfully.");
        }
    }

    private static void insertStudent(Connection conn, int id, String name, String department) throws SQLException {
        String sql = "INSERT INTO students (id, name, department) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("Inserted student: " + name);
        }
    }

    private static void selectStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Students in the database:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Department: "
                        + rs.getString("department"));
            }
        }
    }

    private static void updateStudent(Connection conn, int id, String newDepartment) throws SQLException {
        String sql = "UPDATE students SET department = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDepartment);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Updated student ID " + id + " to department " + newDepartment);
        }
    }

    private static void deleteStudent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Deleted student with ID: " + id);
        }
    }
}
