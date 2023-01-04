package Projekt.System;

import Projekt.MainBoerse;
import Projekt.Service.*;

public class Handling extends Printer{
    private String[] menue = new String[8];
    public InputChecker validate = new InputChecker();
    public FahrzeugHersteller fabrik = new FahrzeugHersteller();
    public Werkstatt werkstatt = new Werkstatt();
    public Detectiv schnueffler = new Detectiv();
    public Schredder abNachPolen = new Schredder();

    public IDInputChecker whatID = new IDInputChecker();
    public int secondUse = 0;
    private int intNummer;
    public String wahl = "N";

    public void setMenue() {
        menue[0] = "--------------------------------------------------------------";
        menue[1] = "  Fahrzeugboerse         Hauptmenue    von: Sven Roennebeck";
        menue[2] = "1) Fahrzeug anlegen";
        menue[3] = "2) Fahrzeug bearbeiten";
        menue[4] = "3) Fahrzeug suchen";
        menue[5] = "4) Fahrzeug loeschen";
        menue[6] = "0) Boerse beenden";
        menue[7] = "Bitte waehlen";
    }
    //--------------------------------------------Menue ausgeben--------------------------------------------------------
    public  void hauptMenue() {
        setMenue();
        colorChoose(2);// Blau
        for (int i = 0; i <= 7; i++){
            if(i == 2 || i == 7){
                System.out.println(menue[0]+"\n"+menue[i]);
            }else{
                System.out.println(menue[i]);
            }
        }
        intNummer = validate.inputInt(4);
        // wenn die Datenbank leer is, ansage und raus zum HM
        if(intNummer > 4){
            falschEingabe();
        }else if(MainBoerse.speicher.anzahlKfzGesamt() == 0 && intNummer != 1){
            colorChoose(3);// gelb
            sysPrintOut(10,0);// Datenbank leer
            hauptMenue();
        }else {
            switch (intNummer) {
                case 0 -> beenden();
                case 1 -> kfzHandling(1);// anlegen
                case 2 -> kfzHandling(2);// bearbeiten
                case 3 -> kfzHandling(3);// suchen
                case 8 -> kfzHandling(4);// loeschen
                case 4 -> printToDB();
            }
        }
    }// Ende Hauptmenue
    //-----------------------------------------------Beenden------------------------------------------------------------
    private void beenden(){
        colorChoose(3);// gelb
        sysPrintOut(3,0);// wollen sie beenden
        wahl = validate.inputString(1,4);
        //wahl = inputHandling.findInLine("j");
        if(wahl.equals("J")){
            sysPrintOut(25,0);// auf wiedersehen
            System.exit(0);
        }else if(wahl.equals("N")){
            hauptMenue();
        }else{
            falschEingabe();
        }
    }// Ende beenden
    //----------------------------------------------Handling------------------------------------------------------------
    public void kfzHandling(int x) {
        if (secondUse == 0) {
            if(x == 1) {// Menue wird ausgegeben
                sysPrintOut(4, x);// was für ein fzg
                sysPrintOut(2, 0);// --------
                sysPrintOut(5, 0);// fzg typ
                sysPrintOut(2, 0);// --------
                intNummer = validate.inputInt(4);
            }
            if (x == 1) {// Anlegen
                switch (intNummer) {
                    case 1 -> fabrik.producer(0);// --> Boot
                    case 2 -> fabrik.producer(1);// --> Lkw
                    case 3 -> fabrik.producer(2);// --> Motorrad
                    case 4 -> fabrik.producer(3);// --> Pkw
                    default -> falschEingabe();
                }
            } else if (x == 2) {// Bearbeiten
                werkstatt.fzgBearbeiten();
            } else if (x == 3) {// Suchen
                schnueffler.fzgSuchen();
            } else if (x == 4) {// Löschen
                abNachPolen.fzgLoeschen();
            } else {
                falschEingabe();
            }
        } else {// nochmal?
            colorChoose(2);
            sysPrintOut(6,x);// wollen Sie nochmal ...
            wahl = validate.inputString(1,4);// eingabe wird in grossbuchstaben umgewandelt
            if (wahl.equals("J")) {
                secondUse = 0;
                kfzHandling(x);
            } else if (wahl.equals("N")){
                secondUse = 0;
                hauptMenue();
            }else{
                secondUse = 0;
                falschEingabe();
            }
        }
    }// Ende Handling
    //---------------------------------------------Falsch Eingabe-------------------------------------------------------
    public void falschEingabe(){
        sysPrintOut(1,0);
        java.awt.Toolkit.getDefaultToolkit().beep();
        hauptMenue();
    }


    public void printToDB(){
        MainBoerse.anbindungDB.connectDB();
        MainBoerse.anbindungDB.setCommand("insert into mysqljava values(29,'Robin','Fritz',54)");
        MainBoerse.anbindungDB.sendCommand();
    }
}// Ende Handling