package application.sgbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdSeineMaritime extends SGBD {


    public BdSeineMaritime(){
    super("jdbc:postgresql://asi-pg.insa-rouen.fr:5432/076-SeineMaritime"); 
  }

}
