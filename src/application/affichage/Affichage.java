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
import org.postgis.*;
import org.postgresql.util.*;


public class Affichage {
	 Graph graph;
	 
	 public Affichage(){
		this.graph = new SingleGraph("Projet Théorie des Graphes");
	 }
	 
	 public void afficherResultSet(ResultSet rs){
		 try{
			 Integer nomNode=0;
			while (rs.next()){
				 //System.out.println(rs.getString("spatialrepresentation").toString());
				 //tmpnode = this.graph.addNode(rs.getString("spatialrepresentation").toString());
				PGgeometry geom = (PGgeometry)rs.getObject(1);
				
				if (geom.getGeoType() == Geometry.MULTIPOLYGON ) {
					MultiPolygon mpl = (MultiPolygon)geom.getGeometry();
					System.out.println("MULTIPOLYGON");
					Polygon[] polygons = mpl.getPolygons();
					System.out.println("pl length"+polygons.length);
					for(int i=0;i<polygons.length;i++) {

						for (int r = 0; r < polygons[i].numRings(); r++) {
							LinearRing rng = polygons[i].getRing(r);
							//System.out.println("Ring: " + r);

							double x,y;
							Node tmpnode;

							for (int p = 0; p < rng.numPoints(); p++ ) {
								Point pt = rng.getPoint(p);


								x=pt.getX();
								y=pt.getY();

								tmpnode = this.graph.addNode(nomNode.toString());
								if (nomNode>0)
									this.graph.addEdge("E"+nomNode.toString(), nomNode-1, nomNode);
								tmpnode.addAttribute("layout.frozen");
								tmpnode.addAttribute("xy", x, y);
								nomNode++;
							}
						}
					}
				}
					Node tmpnode;
				if (geom.getGeoType() == Geometry.MULTILINESTRING ) {
					MultiLineString	mls = (MultiLineString)geom.getGeometry();
					System.out.println("MULTILINES");
					LineString[] lines = mls.getLines();

					//Polygon[] polygons = mpl.getPolygons();
					System.out.println("LINES length"+lines.length);
					
					for(int i=0;i<lines.length;i++) {
						
						for (int p = 0; p < lines[i].numPoints(); p++ ) {
							boolean newLIne = true;
							Point pt = lines[i].getPoint(p);
							double x,y;
							x=pt.getX();
							y=pt.getY();

							tmpnode = this.graph.addNode(nomNode.toString());
							if ((nomNode>0) && !newLIne){
								this.graph.addEdge("E"+nomNode.toString(), nomNode-1, nomNode);
							}else{
								newLIne=false;
							}

							tmpnode.addAttribute("layout.frozen");
							tmpnode.addAttribute("xy", x, y);
							nomNode++;
						}
					}
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		this.afficher();
	 }
	 
	 private void afficher(){
		this.graph.display();
	 }
	 public void clear(){
		 this.graph.clear();
	 }
 }
