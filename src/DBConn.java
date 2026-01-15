import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {   // ✅ your class is called DBConn
        private static final String URL = "jdbc:mysql://localhost:3306/studentsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Jalpa.db123";

    // ✅ this method must exist
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
