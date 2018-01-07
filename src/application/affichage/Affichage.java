package application.affichage; 

import java.io.*;
import java.sql.*;
import ihm.Ihm;
import ihm.UserInputs;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import application.sgbd.BdSeineMaritime;
import application.sgbd.BdOrange;
import application.sgbd.str2request;


public class Affichage {
	 Graph graph;
	 
	 public Affichage(){
		this.graph = new SingleGraph("Projet Théorie des Graphes");
	 }
	 
	 public void afficherResultSet(ResultSet rs){
		 try{
			 while (rs.next()){
				 System.out.println(rs.getString("spatialrepresentation").toString());
				this.graph.addNode(rs.getString("spatialrepresentation").toString());
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		this.afficher();
	 }
	 
	 private void afficher(){
		this.graph.display();
	 }
 }
