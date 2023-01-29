package Projekt.System;
import Projekt.Fahrzeuge.Boot;
import Projekt.Fahrzeuge.Lkw;
import Projekt.Fahrzeuge.Motorrad;
import Projekt.Fahrzeuge.Pkw;
import Projekt.MainBoerse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {
    private static String url = "jdbc:mysql://localhost:3306/maasen";
    private static String user = "root";

    private static String password = "";
    private static String db = "assauto";//  mysqljava
    private static String command;// = "insert into mysqljava values(11,'Robin','Fritz',54)";

    private static Connection con;// Verbindung zur DB
    private static Statement insert;

    //-------------------------------------Verbindung aufbauen------------------------------------------------------

    public void connectDB() {
        try {
            // Verbindung aufbauen
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Verbindung erfolgreich hergestellt");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //---------------------------------------Befehl an DB senden----------------------------------------------------

    public void sendCommand() {
        try {
            insert = con.createStatement();
            //    insert.execute("insert into mysqljava values(12,'Sven','Hans',34)");
            insert.execute(command);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setCommand(String command) {
        DBConnector.command = command;
    }



    public void printToDB(){







        connectDB();

        String command = "";
        for(int array = 0; array < 4;array++){
            for(int index = 0; index < MainBoerse.speicher.anzahlKfzListe(array);index++){

                String marke = MainBoerse.speicher.getFahrzeug(array,index).getMarke();
                String model = MainBoerse.speicher.getFahrzeug(array,index).getModell();
                int baujahr = MainBoerse.speicher.getFahrzeug(array,index).getBaujahr();
                String farbe = MainBoerse.speicher.getFahrzeug(array,index).getFarbe();
                double preis = MainBoerse.speicher.getFahrzeug(array,index).getPreis();
                int anzahlPropeller = 0;
                double klasse = 0.0;
                boolean beiwagen = false;
                int anzahlTueren = 0;

                if(array == 0){
                    anzahlPropeller = ((Boot) MainBoerse.speicher.getFahrzeug(array,index)).getAnzahlRotorBlaetter();
                }else if(array == 1){
                    klasse = ((Lkw) MainBoerse.speicher.getFahrzeug(array,index)).getKlasse();
                }else if(array == 2){
                    beiwagen = ((Motorrad) MainBoerse.speicher.getFahrzeug(array,index)).isBeiwagen();
                }else if(array == 3){
                    anzahlTueren = ((Pkw)MainBoerse.speicher.getFahrzeug(array,index)).getAnzahlTueren();
                }


                if(array == 0 && index == 0){
                    command = "insert into assauto values("+DBid+",'"+marke+"','"+model+"',"+baujahr+",'"+farbe+"',"+preis+","+anzahlPropeller+","+klasse+","+beiwagen+","+anzahlTueren+"),\n";
                }else if(array == 3 && (index == MainBoerse.speicher.anzahlKfzListe(array)-1)){
                    command = "("+DBid+",'"+marke+"','"+model+"',"+baujahr+",'"+farbe+"',"+preis+","+anzahlPropeller+","+klasse+","+beiwagen+","+anzahlTueren+");";
                }else{
                    command = "("+DBid+",'"+marke+"','"+model+"',"+baujahr+",'"+farbe+"',"+preis+","+anzahlPropeller+","+klasse+","+beiwagen+","+anzahlTueren+"),\n";
                }
            }
        }

        System.out.println(command);
        MainBoerse.handling.hauptMenue();
    }



    int DBid = 1;
    public void sendCommandToDB(int array, int index){

        String marke = MainBoerse.speicher.getFahrzeug(array,index).getMarke();
        String model = MainBoerse.speicher.getFahrzeug(array,index).getModell();
        int baujahr = MainBoerse.speicher.getFahrzeug(array,index).getBaujahr();
        String farbe = MainBoerse.speicher.getFahrzeug(array,index).getFarbe();
        double preis = MainBoerse.speicher.getFahrzeug(array,index).getPreis();
        int anzahlPropeller = 0;
        double klasse = 0.0;
        boolean beiwagen = false;
        int anzahlTueren = 0;

        if(array == 0){
            anzahlPropeller = ((Boot) MainBoerse.speicher.getFahrzeug(array,index)).getAnzahlRotorBlaetter();
        }else if(array == 1){
            klasse = ((Lkw) MainBoerse.speicher.getFahrzeug(array,index)).getKlasse();
        }else if(array == 2){
            beiwagen = ((Motorrad) MainBoerse.speicher.getFahrzeug(array,index)).isBeiwagen();
        }else if(array == 3){
            anzahlTueren = ((Pkw)MainBoerse.speicher.getFahrzeug(array,index)).getAnzahlTueren();
        }

        setCommand("insert into assauto values("+DBid+",'"+marke+"','"+model+"',"+baujahr+",'"+farbe+"',"+preis+","+anzahlPropeller+","+klasse+","+beiwagen+","+anzahlTueren+"),\n");






        sendCommand();
        DBid++;
    }// ende print to DB














}
