package application;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import application.sgbd.SGBD;
import application.sgbd.BdSeineMaritime;
import java.sql.*;

public class Main {
    public static void main (String[] args){
        System.out.println("Hello World");
        Graph graph = new SingleGraph("Tutorial 1");
        graph.addNode("A" );
        graph.addNode("B" );
        graph.addNode("C" );
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        graph.display();


        BdSeineMaritime bdConnection = new BdSeineMaritime();
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
    }
}
