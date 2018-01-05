package application.sgbd;
import application.sgbd.SGBD;
import application.sgbd.BdSeineMaritime;
import java.sql.*;
import ihm.UserInputs;


public class str2request {
  private BdOrange bdFrance;
  private BdSeineMaritime bdsm;
  public str2request(){
    this.bdFrance = new BdOrange();
    this.bdsm = new BdSeineMaritime();
  }

  public ResultSet requeteCarte(UserInputs in){
    ResultSet resultats = null;
    String requete;
    Connection con;
    switch(in.getScale()){
      case 1 :
      con = this.bdFrance.getConnection();
      requete = "Select * from limitesdepartements;";
      try{
        Statement stmt = con.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
        bdFrance.deconnexion();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
      break;
      case 2 :
      con = this.bdFrance.getConnection();
      requete  =  "Select * from communes where \"codeDepartement\"='"+in.getZoneID()+"';";
      try{
        Statement stmt = con.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
        bdFrance.deconnexion();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
      break;
      case 3 :
      con = this.bdsm.getConnection();
      requete = "Select * from cadastre where \"code_com\"='"+in.getZoneID()+"';";
      try{
        Statement stmt = con.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
        bdsm.deconnexion();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }

    }
    return resultats;
  }


  public ResultSet requeteTel(UserInputs in){
    ResultSet resultats = null;
    String requete = "";
    Connection con;
    con = this.bdFrance.getConnection();
    if (in.isUseDates()){
      switch(in.getScale()){
        case 1 :
          requete = "Select * from spatialisation where \"date\" between '"+in.getStartDate()+"' and '"+in.getEndDate()+"';";
        break;
        case 2 :
          requete = "Select * from spatialisation where \"date\" between '"+in.getStartDate()+"' and '"+in.getEndDate()+"' and \"idDepartement\"='"+in.getZoneID()+"';";
        break;
        case 3 :
          requete = "Select * from spatialisation where \"date\" between '"+in.getStartDate()+"' and '"+in.getEndDate()+"' and \"idCommune\"='"+in.getZoneID()+"';";
        break;
      }
    }else{
      switch(in.getScale()){
        case 1 :
          requete = "Select * from spatialisation;";
        break;
        case 2 :
          requete = "Select * from spatialisation where \"idDepartement\"='"+in.getZoneID()+"';";
        break;
        case 3 :
          requete = "Select * from spatialisation where \"idCommune\"='"+in.getZoneID()+"';";
        break;
    }
  }
  try{
    Statement stmt = con.createStatement();
    resultats = stmt.executeQuery(requete);
    resultats.next();
    bdFrance.deconnexion();
  }catch (SQLException e){
    e.printStackTrace();
    return null;
  }
  return resultats;
  }
}
