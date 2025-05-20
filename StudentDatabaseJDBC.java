import java.sql.*;

public class StudentDatabaseJDBC {
    // JDBC URL, username, password
    static final String URL = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Connected to the database.");

            // INSERT
            insertStudent(conn, 1, "Vansh", 20, "A");

            // SELECT
            System.out.println("\nStudents in database:");
            selectStudents(conn);

            // UPDATE
            updateStudentGrade(conn, 1, "A+");
            System.out.println("\nAfter updating grade:");
            selectStudents(conn);

            // DELETE
            deleteStudent(conn, 1);
            System.out.println("\nAfter deleting student:");
            selectStudents(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT operation
    public static void insertStudent(Connection conn, int id, String name, int age, String grade) throws SQLException {
        String sql = "INSERT INTO students (id, name, age, grade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, grade);
            pstmt.executeUpdate();
            System.out.println("Inserted student: " + name);
        }
    }

    // SELECT operation
    public static void selectStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d, Grade: %s%n",
                        rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("grade"));
            }
        }
    }

    // UPDATE operation
    public static void updateStudentGrade(Connection conn, int id, String newGrade) throws SQLException {
        String sql = "UPDATE students SET grade = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newGrade);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            System.out.println("Updated grade for student ID " + id + ". Rows affected: " + rows);
        }
    }

    // DELETE operation
    public static void deleteStudent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("Deleted student ID " + id + ". Rows affected: " + rows);
        }
    }
}
