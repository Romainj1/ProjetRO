package application.sgbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SGBD {

    protected static String bd ;
    private static String user = "grtt12";
    private static String passwd = "grtt12";

    private static Connection conn;
    public SGBD(String bd){
      this.bd = bd;
    }

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

    //SELECT "nomCommune" FROM communes where "codeDepartement" = '76';
    //\dt
    // SELECT "nomCommune", "codeDepartement" FROM communes where "codeInsee" = '76540';

}
