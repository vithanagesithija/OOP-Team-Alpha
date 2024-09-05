package DBLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://49.13.200.232:3308/techrepair",
                "malith",
                "ThBGSdeObmVuXR3RjfT6Z2yMYaWzGbEgzQJMFtcpuv5e9wYLirzF2j85CcyFQKrQ"
        );
    }

    public static DbConnection getInstance() throws SQLException {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
