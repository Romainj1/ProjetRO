package application;
import java.io.*;
import ihm.Ihm;
import ihm.UserInputs;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import application.sgbd.BdSeineMaritime;
import application.sgbd.BdOrange;
import application.sgbd.str2request;
import java.sql.*;
import application.affichage.Affichage;

import org.postgis.*;
// import org.graphstream.geography.*;

public class Main {
    public static void main (String[] args){
		
		//Instance Affichage et str2request
		str2request s2r = new str2request();
		Affichage affichage = new Affichage();
		
		// On Démarre l'IHM
		UserInputs ui = Ihm.getUserInputs();
		
		// On requête la carte : (à echelle demandé)
		ResultSet rs = s2r.requeteCarte(ui);
		
		affichage.afficherResultSet(rs);
		
		
		
        System.out.println("Hello World");
        Graph graph = new SingleGraph("Tutorial 1");
        graph.addNode("A" );
        graph.addNode("B" );
        graph.addNode("C" );
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        //graph.display();
        
        /*
        try{
			UserInputs ui = Ihm.getUserInputs();
			str2request s2r = new str2request();
			ResultSet rs = s2r.requeteCarte(ui);
			
			//MultiLineString mls = (MultiLineString)rs.getString("st_asgml");
			graph.addNode(rs.getString("spatialrepresentation").toString());
			
	  
			
			graph.addAttribute("ui.stylesheet");
			graph.display(true);   // No auto-layout.
		}catch(Exception e){
			System.out.println(e.getMessage());
		}*/
		



        BdOrange bdConnection = new BdOrange();
        Connection con = bdConnection.getConnection();

        ResultSet resultats = null;
        String requete = "SELECT * FROM communes where \"codeInsee\" = '76540';";
        //request exemple
        try {
            Statement stmt = con.createStatement();
            resultats = stmt.executeQuery(requete);
            resultats.next();
            // ResultSetMetaData rsmd;
            // rsmd = results.getMetaData();
            System.out.println("resultats : "+resultats.getString("nomCommune"));
        } catch (SQLException e) {
            System.out.println("exception"+e.getMessage());
        }

        ResultSet resultats2 = null;
        String requete2 = "SELECT * FROM limitesdepartements";
        //request exemple
        try {
            Statement stmt2 = con.createStatement();
            resultats2 = stmt2.executeQuery(requete2);
            	resultats2.next();
            System.out.println(resultats2.toString());
            // ResultSetMetaData rsmd;
            // rsmd = results.getMetaData();
            System.out.println("resultats : "+resultats2.getString("gid"));
        } catch (SQLException e) {
            System.out.println("exception"+e.getMessage());
        }
    }
}
