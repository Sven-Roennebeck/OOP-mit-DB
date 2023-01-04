package Projekt.Service;

import Projekt.Fahrzeuge.Boot;
import Projekt.Fahrzeuge.Lkw;
import Projekt.Fahrzeuge.Motorrad;
import Projekt.Fahrzeuge.Pkw;
import Projekt.MainBoerse;
import Projekt.System.Printer;

public class Werkstatt extends Printer {
    private int array;
    private int id;

    public void fzgBearbeiten(){
        setNr(1);// Durchnummerierung
        colorChoose(0);
        // Ausgabe aller Fahrzeuge
        for (int i = 0; i < 4; i++) {
            printOut(i,0);
        }
        colorChoose(2);// blau
        sysPrintOut(7, 0);// welches bearbeiten
        int idWahlInput = MainBoerse.handling.validate.inputInt(3);// ID im inputchecker eiingeben
        MainBoerse.handling.whatID.checkID(idWahlInput,0);// ID wird dem richtigen Array zugeordnet
        colorChoose(0);// weiss
        einzelPrintOut(idWahlInput, array, id,false, "");// Ausgabe ausgewähltes Kfz
        colorChoose(2);// blau
        MainBoerse.eingabe.eingabeDaten(array,1);// Eingabefür entspechendes Fahrzeug aufrufen

        // laut Aufgabe nicht gefordert
        //colorChoose(3);// gelb
        //sysPrintOut(16,0);// wollen Sie speichern?
        //String wahl = MainBoerse.handling.validate.inputString(1,0);// wahl <--
        //if(wahl.equals("J")) {
        MainBoerse.speicher.getFahrzeug(array, id).setMarke(MainBoerse.eingabe.getMarke());
        MainBoerse.speicher.getFahrzeug(array, id).setModell(MainBoerse.eingabe.getModel());
        MainBoerse.speicher.getFahrzeug(array, id).setBaujahr(MainBoerse.eingabe.getBaujahr());
        MainBoerse.speicher.getFahrzeug(array, id).setFarbe(MainBoerse.eingabe.getFarbe());
        MainBoerse.speicher.getFahrzeug(array, id).setPreis(MainBoerse.eingabe.getPreis());
        MainBoerse.speicher.getFahrzeug(array, id).setPs(MainBoerse.eingabe.getPs());
        switch (array){
            case 0 -> ((Boot)MainBoerse.speicher.getFahrzeug(array, id)).setAnzahlRotorBlaetter(MainBoerse.eingabe.getPropeller());
            case 1 -> ((Lkw)MainBoerse.speicher.getFahrzeug(array, id)).setKlasse(MainBoerse.eingabe.getKlasse());
            case 2 -> ((Motorrad)MainBoerse.speicher.getFahrzeug(array, id)).setBeiwagen(MainBoerse.eingabe.isBeiwagen());
            case 3 -> ((Pkw)MainBoerse.speicher.getFahrzeug(array, id)).setAnzahlTueren(MainBoerse.eingabe.getTueren());
        }
        MainBoerse.handling.secondUse = 1;// nochmal
        MainBoerse.handling.kfzHandling(2);// --> bearbeiten
/*        }else if(wahl.equals("N")){
            MainBoerse.handling.secondUse = 1;// nochmal
            MainBoerse.handling.kfzHandling(2);
        }else{
            MainBoerse.handling.secondUse = 0;// Reset nochmal
            MainBoerse.handling.falschEingabe();
        }

 */
    }// Ende bearbeiten
    // Übergabe der Werte von IDInputChecker
    public void setArrayID(int array,int id){
        this.array = array;
        this.id = id;
    }
}// Ende Werkstatt
