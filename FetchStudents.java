import java.sql.*;

public class FetchStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root"; // update if needed
        String password = "shafi";

        try {
            // Optional: manually load driver (helps ensure it works)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL studentdb!\n");

            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("ID\tRoll\tName");
            System.out.println("--------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                int roll = rs.getInt("roll");
                String name = rs.getString("name");

                System.out.println(id + "\t" + roll + "\t" + name);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
