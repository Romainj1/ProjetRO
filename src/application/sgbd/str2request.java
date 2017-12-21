package application.sgbd;
import application.sgbd.SGBD;
import application.sgbd.BdSeineMaritime;
import java.sql.*;
import ihm.UserInputs;


public class str2request {
  private SGBD bdConnection;
  public str2request(){
    this.bdConnection = new SGBD();
  }

  public ResultSet requeteCarte(UserInputs in){
    if (in.getScale() == 2){
      Connection con = this.bdConnection.getConnection();
      ResultSet resultats = null;
      String requete  =  "Select * from communes where \"codeDepartement\"='"+in.getZoneID()+"'";
      try{
        Statement stmt = con.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
        bdConnection.deconnexion();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
      return resultats;
    }
    return null;

  }

}
