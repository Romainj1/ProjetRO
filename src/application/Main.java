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
		
		//do{
			// On Démarre l'IHM
			UserInputs ui = Ihm.getUserInputs();
			
			// On requête la carte : (à echelle demandé)
			ResultSet rsCarte = s2r.requeteCarte(ui);
			
			//Affiche la carte
			System.out.println("AFFICHAGE CARTE");
			affichage.afficherResultSet(rsCarte);
			
			//Chargement telephone
			System.out.println("CHARGEMENT TEL");
			ResultSet rsTelephone = s2r.requeteTel(ui);
			
			//Affichage du telephone
			System.out.println("AFFICHEGE TEL");
			affichage.afficherResultSet(rsTelephone);
			
			affichage.afficher();
			
		//}while(true);
	}
		
        

}
