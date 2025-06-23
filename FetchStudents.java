import java.sql.*;
import java.util.Scanner;

public class FetchStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "shafi";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter roll: ");
        int roll = scanner.nextInt();
        scanner.nextLine(); // clear newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("\nConnected to MySQL studentdb!");

            String query = "INSERT INTO students (roll, name) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, roll);
            pstmt.setString(2, name);

            int rowsInserted = pstmt.executeUpdate(); 

            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully!");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
