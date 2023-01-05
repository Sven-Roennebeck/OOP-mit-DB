package Projekt;
import Projekt.Service.InputVar;
import Projekt.System.*;

public class MainBoerse{
    public static Handling handling = new Handling();
    public static InputVar eingabe = new InputVar();
    public static Garage speicher = new Garage();
    public static DBConnector anbindungDB = new DBConnector();
    public static Random generator = new Random();
    public static void main(String[] args) {
        speicher.initializeSpeicher();// Array wird mit Listen geladen
        // zum start mit leerer Datenbank Zeile 13 einfach auskommentieren
        generator.randomFahrzeuge(5000000);// Random Objekte erstellen


        /*
                                    Programmstrucktur



          |---Klasse Fahrzeug
                        |
                     vererbt an
                        |
                        |--> Boot
                        |--> Lkw
                        |--> Motorrad
                        |--> Pkw

          |---Klasse Printer
                        |
                     vererbt an
                        |
                        |--> Detectiv
                        |--> IDInputChecker
                        |--> InputVar
                        |--> Werkstatt
                        |--> Handling
                        |--> InputChecker

          |---Klasse IDInputChecker
                        |
                    vererbt an
                        |
                        |--> Schredder


*/
/*
        // Summe aller erstellten Test-Fahrzeuge anzeigen
        String[] typ = {"Boote:","Lkw's:","Motorraeder:","Pkw's:"};
        System.out.println("\nSummary");
        for(int i = 0; i < 4; i++){
            System.out.format("%-15s%-50s",typ[i],+speicher.anzahlKfzListe(i));
            System.out.println();
        }
*/

        // ab hier gehts ins programm
        handling.hauptMenue();
    }// Ende main
}// Ende MainBoerse