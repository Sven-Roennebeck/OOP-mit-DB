package Projekt.Service;

import Projekt.Fahrzeuge.Boot;
import Projekt.Fahrzeuge.Lkw;
import Projekt.Fahrzeuge.Motorrad;
import Projekt.Fahrzeuge.Pkw;
import Projekt.MainBoerse;
import Projekt.System.Printer;

public class Detectiv extends Printer {

    private String suchString;

    public void setSuchString(String zeichenKette) {
        this.suchString = zeichenKette;
    }
    private int nummer = 1;

    public void fzgSuchen() {
        suchString = null;
        nummer = 1;
        sysPrintOut(13, 0);// Suchbegriff eingeben
        // String untersuchen was drin ist
        MainBoerse.handling.validate.suchbegriff();
        colorChoose(0);// bugfix color nicht weiss nach suchbegriffabfrage
        // Suche neu
        if (suchString != null) {
            for (int i = 0; i < 4; i++) {
                for (int z = 0; z < MainBoerse.speicher.anzahlKfzListe(i); z++) {
                    if (MainBoerse.speicher.getFahrzeug(i, z).getMarke().contains(suchString)) {
                        einzelPrintOut(nummer, i, z, true, suchString);
                        nummer++;
                    } else if (MainBoerse.speicher.getFahrzeug(i, z).getModell().contains(suchString)) {
                        einzelPrintOut(nummer, i, z, true, suchString);
                        nummer++;
                    } else if (String.valueOf(MainBoerse.speicher.getFahrzeug(i, z).getBaujahr()).contains(suchString)) {
                        einzelPrintOut(nummer, i, z, true, suchString);
                        nummer++;
                    } else if (MainBoerse.speicher.getFahrzeug(i, z).getFarbe().contains(suchString)) {
                        einzelPrintOut(nummer, i, z, true, suchString);
                        nummer++;
                    } else if (String.valueOf(MainBoerse.speicher.getFahrzeug(i, z).getPreis()).contains(suchString)) {
                        einzelPrintOut(nummer, i, z, true, suchString);
                        nummer++;
                    }
                    if (i == 0) {// Boote
                        if (String.valueOf(((Boot) MainBoerse.speicher.getFahrzeug(i, z)).getAnzahlRotorBlaetter()).contains(suchString)) {
                            einzelPrintOut(nummer, i, z, true, suchString);
                            nummer++;
                        }
                    } else if (i == 1) {// Lkw´s
                        if (String.valueOf(((Lkw) MainBoerse.speicher.getFahrzeug(i, z)).getKlasse()).contains(suchString)) {
                            einzelPrintOut(nummer, i, z, true, suchString);
                            nummer++;
                        }
                    } else if (i == 2) {// Motorräder
                        String jaNein = String.valueOf(((Motorrad) MainBoerse.speicher.getFahrzeug(i, z)).isBeiwagen());
                        if (jaNein.equals("true")) {
                            jaNein = "Ja";
                        } else {
                            jaNein = "Nein";
                        }
                        if (jaNein.contains(suchString)) {
                            einzelPrintOut(nummer, i, z, true, suchString);
                            nummer++;
                        }
                    } else if (i == 3) {// Pkw´s
                        if (String.valueOf(((Pkw) MainBoerse.speicher.getFahrzeug(i, z)).getAnzahlTueren()).contains(suchString)) {
                            einzelPrintOut(nummer, i, z, true, suchString);
                            nummer++;
                        }
                    }
                }
            }
            //---------------------------------------------Abschluss--------------------------------------------------------
            // wenn nichts gefunden wurde
            if (nummer == 1) {
                sysPrintOut(14, 0);// Kein treffer
            }
        }
        MainBoerse.handling.secondUse = 1;
        MainBoerse.handling.kfzHandling(3);// -> Suchen
    }// Ende fzgSuchen
}// Ende Detectiv


