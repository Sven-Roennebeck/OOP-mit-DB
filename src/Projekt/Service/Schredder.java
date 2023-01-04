package Projekt.Service;

import Projekt.MainBoerse;
public class Schredder extends IDInputChecker{
    private int array;
    private int id;

    public void fzgLoeschen() {
        setNr(1);// Durchnummerierung
        // Ausgabe aller Fahrzeuge
        for (int i = 0; i < 4; i++) {
            colorChoose(0);
            printOut(i,0);
        }
        colorChoose(3);// gelb
        sysPrintOut(8, 0);// welches loeschen
        int idWahlInput = MainBoerse.handling.validate.inputInt(4);
        // check ID durch Vererbung
        checkID(idWahlInput,1);// feststellen Welche ID
        colorChoose(0);// weiss
        einzelPrintOut(idWahlInput, array, id,false, "");// Ausgabe ausgewähltes Kfz
        colorChoose(3);// gelb
        sysPrintOut(15,0);// sicher Löschen?
        MainBoerse.handling.secondUse = 1;
        String wahl = MainBoerse.handling.validate.inputString(1,0);// wahl <--
        if (wahl.equals("J")) {
            MainBoerse.speicher.fzgLoeschen(array, id);// fzg löschen
            if (MainBoerse.speicher.anzahlKfzGesamt() > 0) {
                MainBoerse.handling.kfzHandling(4);// --> loeschen
            }else{
                MainBoerse.handling.secondUse = 0;// Reset "nocheinmal"
                MainBoerse.handling.hauptMenue();
            }
        } else if (wahl.equals("N")) {
            MainBoerse.handling.secondUse = 0;// Reset "nocheinmal"
            MainBoerse.handling.hauptMenue();
        } else {
            MainBoerse.handling.secondUse = 0;// Reset "nocheinmal"
            MainBoerse.handling.falschEingabe();
        }
    }// Ende loeschen
    public void setArrayID(int array,int id){
        this.array = array;
        this.id = id;
    }
}// Ende Schredder
