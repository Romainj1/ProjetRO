package application.sgbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdOrange extends SGBD {

    public BdOrange(){
      super("jdbc:postgresql://asi-pg.insa-rouen.fr:5432/orange-12");

    }


}
