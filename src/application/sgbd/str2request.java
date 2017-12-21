package application.sgbd;
import application.sgbd.SGBD;
import java.sql.*;
import ihm.UserInputs;


public class str2request {


  public String requeteCarte(UserInputs in){
    if in.getScale == 2{
      String requete  =  "Select * from communes where \"codeDepartement\"='"+in.getzoneID()+"'";
    }

  }

}
