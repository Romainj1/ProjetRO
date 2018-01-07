package application.sgbd;
import application.sgbd.SGBD;
import application.sgbd.BdSeineMaritime;
import java.sql.*;
import ihm.UserInputs;
import org.postgis.*;


public class str2request {
  private BdOrange bdFrance;
  private BdSeineMaritime bdsm;
  private Connection conFrance;
  private Connection conSeineMaritime;
  public str2request(){
    this.bdFrance = new BdOrange();
    this.bdsm = new BdSeineMaritime();
    this.conFrance = this.bdFrance.getConnection();
    this.conSeineMaritime = this.bdsm.getConnection();
  }

  public ResultSet requeteCarte(UserInputs in){
    ResultSet resultats = null;
    String requete;
    Connection con;
    switch(in.getScale()){
      case 1 :
      requete = "SELECT spatialrepresentation FROM limitesdepartements;";
      try{
        Statement stmt = this.conFrance.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
        
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
      break;
      case 2 :
      requete  =  "Select spatialrepresentation from communes where \"codeDepartement\"='"+in.getZoneID()+"';";
      try{
        Statement stmt = this.conFrance.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
      break;
      case 3 :
      requete = "Select spatialrepresentation from cadastre where \"code_com\"='"+in.getZoneID()+"';";
      try{
        Statement stmt = this.conSeineMaritime.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
	  break;
	  case 4 :
      requete = "Select spatialrepresentation from parcelles where \"code_com\"='"+in.getZoneID()+"';";
      try{
        Statement stmt = this.conSeineMaritime.createStatement();
        resultats = stmt.executeQuery(requete);
        resultats.next();
      }catch (SQLException e){
        e.printStackTrace();
        return null;
      }
	  break;
	  
    }
    return resultats;
  }


  public ResultSet requeteTel(UserInputs in){
    ResultSet resultats = null;
    String requete = "";
    if (in.isUseDates()){
		
      switch(in.getScale()){
        case 1 :
          requete = "Select distinct location as spatialrepresentation from spatialisation where \"date\" between '"+in.getStartDate()+"' and '"+in.getEndDate()+"';";
          // Select location as spatialrepresentation from spatialisation where "date" between '2012-01-13 07:32:000' and '2012-01-13 07:33:000';
        break;
        case 2 :
          requete = "Select distinct location as spatialrepresentation from spatialisation where \"date\" between '"+in.getStartDate()+"' and '"+in.getEndDate()+"' and \"idDepartement\"='"+in.getZoneID()+"';";
        break;
        case 3 : case 4 :
          requete = "Select distinct location as spatialrepresentation from spatialisation where \"date\" between '"+in.getStartDate()+"' and '"+in.getEndDate()+"' and \"idCommune\"='76"+in.getZoneID()+"';";
        break;
      }
    }else{
      switch(in.getScale()){
        case 1 :
          requete = "Select distinct location as spatialrepresentation from spatialisation;";
        break;
        case 2 :
          requete = "Select distinct location as spatialrepresentation from spatialisation where \"idDepartement\"='"+in.getZoneID()+"';";
        break;
        case 3 : case 4 :
          requete = "Select distinct location as spatialrepresentation  from spatialisation where \"idCommune\"='76"+in.getZoneID()+"';";
        break;
    }
  }
  try{
    Statement stmt = this.conFrance.createStatement();
    resultats = stmt.executeQuery(requete);
    resultats.next();
  }catch (SQLException e){
    e.printStackTrace();
    return null;
  }
  return resultats;
  }
  
}
