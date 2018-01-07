package application.sgbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SGBD {

    private String bd ;
    private String user = "grtt12";
    private String passwd = "grtt12";

    private Connection conn;
    public SGBD(String bd){
      this.bd = bd;
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(bd, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void deconnexion() throws SQLException {

        conn.close();
    }

    //SELECT "nomCommune" FROM communes where "codeDepartement" = '76';
    //\dt
    // SELECT "nomCommune", "codeDepartement" FROM communes where "codeInsee" = '76540';

}
