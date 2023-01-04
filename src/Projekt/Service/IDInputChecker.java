package Projekt.Service;

import Projekt.MainBoerse;
import Projekt.System.Printer;

public class IDInputChecker extends Printer {


    public void checkID(int idWahlInput, int loesch){
        if (idWahlInput < 1) {
            colorChoose(3);// gelb
            sysPrintOut(12,0);// Haha
            MainBoerse.handling.falschEingabe();
        } else {
            //-----------------------------------------------Bestandsaufnahme-----------------------------------------------
            int array = 0;
            int idIndex = idWahlInput - 1;
            if (idWahlInput > MainBoerse.speicher.anzahlKfzGesamt()){
                colorChoose(3);// gelb
                sysPrintOut(11,0);// schau mal zu groß
                MainBoerse.handling.falschEingabe();
            } else {
                // in welcher Liste ist gewählte ID
                if (idWahlInput - MainBoerse.speicher.anzahlKfzListe(0) <= 0) {
                    array = 0;
                } else if (idWahlInput - MainBoerse.speicher.anzahlKfzListe(0) - MainBoerse.speicher.anzahlKfzListe(1) <= 0) {
                    array = 1;
                    idIndex = idIndex - MainBoerse.speicher.anzahlKfzListe(0);
                } else if (idWahlInput - MainBoerse.speicher.anzahlKfzListe(0) - MainBoerse.speicher.anzahlKfzListe(1) - MainBoerse.speicher.anzahlKfzListe(2) <= 0) {
                    array = 2;
                    idIndex = idIndex - MainBoerse.speicher.anzahlKfzListe(0) - MainBoerse.speicher.anzahlKfzListe(1);
                } else {
                    array = 3;
                    idIndex = idIndex - MainBoerse.speicher.anzahlKfzListe(0) - MainBoerse.speicher.anzahlKfzListe(1) - MainBoerse.speicher.anzahlKfzListe(2);
                }
            }
            // Werte in den entsprechenden Klassen setzen
            if(loesch == 1){
                MainBoerse.handling.abNachPolen.setArrayID(array,idIndex);
            }else{
                MainBoerse.handling.werkstatt.setArrayID(array,idIndex);
            }
        }
    }// Ende ID Check
}// Ende Checker
