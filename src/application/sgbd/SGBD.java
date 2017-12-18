package application.sgbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SGBD {

    private static String bd = "jdbc:postgresql://asi-pg.insa-rouen.fr:5432/orange-12";
    private static String user = "grtt12";
    private static String passwd = "grtt12";

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(bd, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void deconnexion() throws SQLException {

        conn.close();
    }

}
