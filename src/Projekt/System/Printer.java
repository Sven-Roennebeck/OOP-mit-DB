package Projekt.System;


import Projekt.MainBoerse;
import Projekt.Fahrzeuge.*;

public class Printer{// extendet in --> Handling, InputVar, InputChecker, IDInputChecker, Detectiv
    private int nr = 1;
    private String beiwagenSubString;
    public int merkmal = 0;
    public void setNr(int nr){
        this.nr = nr;
    }
    public void printOut(int array, int spass){

        for(int i = 0; i < MainBoerse.speicher.anzahlKfzListe(array); i++){
            if(spass == 1){
                int foreground = (int) Math.floor(Math.random() * (16 - 0 + 1) + 0);
                if(foreground == 9){
                    System.out.print("\u001B[32m");// black
                }else if(foreground>8){
                    System.out.print("\u001B[30m");// black
                }
                colorChoose(foreground);
                einzelPrintOut(nr,array,i,false, "");
                colorChoose(0);
                nr++;
            }else{
                einzelPrintOut(nr,array,i,false, "");
                nr++;
            }

        }
    }// Ende printOut

    public void einzelPrintOut(int nr, int array, int liste,boolean stringSuche, String zeichenkette) {
        // Bei treffer Schlagwort matches Klasse
        if(merkmal == 1){
            colorChoose(0);// weiss
        }else if(merkmal == 2){
            colorChoose(3);// gelb
        }
        System.out.format("%-10s", "Nr: " + nr);
        if (stringSuche) {

            if (MainBoerse.speicher.getFahrzeug(array, liste).getMarke().contains(zeichenkette)) {
                System.out.print(" Marke: ");
                subStringColor(array, liste, zeichenkette, 1);
            } else {
                System.out.format("%-25s", " Marke: " + MainBoerse.speicher.getFahrzeug(array, liste).getMarke());
            }

            if (MainBoerse.speicher.getFahrzeug(array, liste).getModell().contains(zeichenkette)) {
                System.out.print(" Modell: ");
                subStringColor(array, liste, zeichenkette, 2);
            } else {
                System.out.format("%-20s", " Modell: " + MainBoerse.speicher.getFahrzeug(array, liste).getModell());
            }

            if ((String.valueOf(MainBoerse.speicher.getFahrzeug(array, liste).getBaujahr()).contains(zeichenkette))) {
                System.out.format(" Baujahr: ");
                subStringColor(array, liste, zeichenkette, 3);
            } else {
                System.out.format("%-15s", " Baujahr: " + MainBoerse.speicher.getFahrzeug(array, liste).getBaujahr());
            }

            if (MainBoerse.speicher.getFahrzeug(array, liste).getFarbe().contains(zeichenkette)) {
                System.out.print(" Farbe: ");
                subStringColor(array, liste, zeichenkette, 4);
            } else {
                System.out.format("%-20s", " Farbe: " + MainBoerse.speicher.getFahrzeug(array, liste).getFarbe());
            }

            if (String.valueOf(MainBoerse.speicher.getFahrzeug(array, liste).getPreis()).contains(zeichenkette)) {
                System.out.print(" Preis: ");
                subStringColor(array, liste, zeichenkette, 5);
            } else {
                System.out.format("%-20s", " Preis: " + MainBoerse.speicher.getFahrzeug(array, liste).getPreis());
            }
            // Ende String Suche
        }else{
            System.out.format("%-25s", " Marke: " + MainBoerse.speicher.getFahrzeug(array, liste).getMarke());
            System.out.format("%-20s", " Modell: " + MainBoerse.speicher.getFahrzeug(array, liste).getModell());
            System.out.format("%-15s", " Baujahr: " + MainBoerse.speicher.getFahrzeug(array, liste).getBaujahr());
            System.out.format("%-20s", " Farbe: " + MainBoerse.speicher.getFahrzeug(array, liste).getFarbe());
            System.out.format("%-20s", " Preis: " + MainBoerse.speicher.getFahrzeug(array, liste).getPreis());
        }

        if (array == 0) {//-------------------------------Boot anzahl Rotorblätter--------------------------------------
            System.out.print(" Anzahl Rotorblaetter: ");
            if (stringSuche && String.valueOf(((Boot) MainBoerse.speicher.getFahrzeug(0, liste)).getAnzahlRotorBlaetter()).contains(zeichenkette)) {
                subStringColor(0, liste, zeichenkette, 6);
                System.out.println();
            } else {
                System.out.println(((Boot) MainBoerse.speicher.getFahrzeug(0, liste)).getAnzahlRotorBlaetter());
            }
        } else if (array == 1) {//-------------------------Lkw Klasse---------------------------------------------------
            System.out.print(" Klasse: ");
            if (stringSuche && String.valueOf(((Lkw) MainBoerse.speicher.getFahrzeug(1, liste)).getKlasse()).contains(zeichenkette)) {
                subStringColor(1, liste, zeichenkette, 7);
            } else {
                System.out.println(((Lkw) MainBoerse.speicher.getFahrzeug(1, liste)).getKlasse());
            }
        } else if (array == 2) {//----------------------Motorrad Beiwagen  Suche----------------------------------------
            System.out.print(" Beiwagen: ");
            String beiwagenSuche;
            beiwagenSubString = "";
            // boolean Umwandeln für Stringsuche
            if (((Motorrad) MainBoerse.speicher.getFahrzeug(2, liste)).isBeiwagen()){
                beiwagenSuche = "Ja";
                beiwagenSubString = "Ja";
            }else{
                beiwagenSuche ="Nein";
                beiwagenSubString = "Nein";
            }
            if (stringSuche) {
                // weiterleitung zu substring wenn nötig
                if(beiwagenSuche.contains(zeichenkette)){
                    subStringColor(2,liste,zeichenkette,8);
                }else{
                    System.out.println(beiwagenSuche);
                }
            } else {
                System.out.println(beiwagenSuche);
            }
        } else if (array == 3) {//------------------------- Pkw anzahl Tueren-------------------------------------------
            System.out.print(" Anzahl Tueren: ");
            if (stringSuche && String.valueOf(((Pkw) MainBoerse.speicher.getFahrzeug(array, liste)).getAnzahlTueren()).contains(zeichenkette)) {
                subStringColor(3,liste,zeichenkette,9);
            } else {
                System.out.println(((Pkw) MainBoerse.speicher.getFahrzeug(array, liste)).getAnzahlTueren());
            }
        }
        merkmal = 0;
    }// Ende einzel Print out
    //----------------------------------------den richtigen Substring einfärben-----------------------------------------
    protected void subStringColor(int array, int index, String suchText, int typ){
        // die Var. sind nötig damit die gesamtlänge in der ausgabe wieder passt
        int markenlaenge = 17;
        int modellaenge = 11;
        int farbenlaenge = 12;
        int preislaenge = 12;
        if(typ == 1) {//------------------------------------Marke-------------------------------------------------------
            if (MainBoerse.speicher.getFahrzeug(array, index).getMarke().length() == suchText.length()) {
                colorChoose(3);// gelb
                System.out.format("%-17s",MainBoerse.speicher.getFahrzeug(array, index).getMarke());
                colorChoose(0);// weiss
            } else if(suchText.length() == 1) {// check bei nur einem Buchstaben
                for(int i = 0; i < MainBoerse.speicher.getFahrzeug(array, index).getMarke().length(); i++){
                    if(MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring(i,(i + 1)).equals(suchText)){
                        colorChoose(3);
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring(i,(i + 1)));
                        colorChoose(0);
                    }else{
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring(i,(i + 1)));
                    }
                    markenlaenge--;
                }
                while (markenlaenge>0){
                    System.out.print(" ");
                    markenlaenge--;
                }
            }else{
                for (int i = 0; i < (MainBoerse.speicher.getFahrzeug(array, index).getMarke().length() - suchText.length()+1); i++) {
                    if (MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring(i, (i + suchText.length())).equals(suchText)) {
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring(0, i));
                        colorChoose(3);// gelb
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring(i, (i + suchText.length())));
                        colorChoose(0);// weiss
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getMarke().substring((i + suchText.length())));
                        markenlaenge--;
                    }
                    markenlaenge--;
                }
                while (markenlaenge>0){
                    System.out.print(" ");
                    markenlaenge--;
                }
            }
        }else if(typ == 2){//-------------------------------------Modell------------------------------------------------
            if (MainBoerse.speicher.getFahrzeug(array, index).getModell().length() == suchText.length()) {
                colorChoose(3);// gelb
                System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getModell());
                colorChoose(0);// weiss
            } else if(suchText.length() == 1) {
                for(int i = 0; i < MainBoerse.speicher.getFahrzeug(array, index).getModell().length(); i++){
                    if(MainBoerse.speicher.getFahrzeug(array, index).getModell().substring(i,(i + 1)).equals(suchText)){
                        colorChoose(3);
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getModell().substring(i,(i + 1)));
                        colorChoose(0);
                    }else{
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getModell().substring(i,(i + 1)));
                    }
                    modellaenge--;
                }
                while (modellaenge>0){
                    System.out.print(" ");
                    modellaenge--;
                }
            }else{
                for (int i = 0; i < (MainBoerse.speicher.getFahrzeug(array, index).getModell().length() - suchText.length()+1); i++) {
                    if (MainBoerse.speicher.getFahrzeug(array, index).getModell().substring(i, (i + suchText.length())).equals(suchText)) {
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getModell().substring(0, i));
                        colorChoose(3);// gelb
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getModell().substring(i, (i + suchText.length())));
                        colorChoose(0);// weiss
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getModell().substring((i + suchText.length())));
                        modellaenge--;
                    }
                    modellaenge--;
                }
                while (modellaenge>0){
                    System.out.print(" ");
                    modellaenge--;
                }
            }
        }else if(typ == 3){//--------------------------------Baujahr----------------------------------------------------
            String baujahr = String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getBaujahr());
            for(int i = 0;i < baujahr.length(); i++){
                if(baujahr.substring(i,i+suchText.length()).equals(suchText)){
                    System.out.print(baujahr.substring(0,i));
                    colorChoose(3);
                    System.out.print(baujahr.substring(i,i+suchText.length()));
                    colorChoose(0);
                    System.out.print(baujahr.substring(i+suchText.length()));

                    i = i+baujahr.length();
                    System.out.print(" ");
                }
            }
        }else if(typ == 4){//----------------------------------Farbe----------------------------------------------------
            if (MainBoerse.speicher.getFahrzeug(array, index).getFarbe().length() == suchText.length()) {
                colorChoose(3);// gelb
                System.out.format("%-12s",MainBoerse.speicher.getFahrzeug(array, index).getFarbe());
                colorChoose(0);// weiss
            } else if(suchText.length() == 1) {
                for(int i = 0; i < MainBoerse.speicher.getFahrzeug(array, index).getFarbe().length(); i++){
                    if(MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring(i,(i + 1)).equals(suchText)){
                        colorChoose(3);
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring(i,(i + 1)));
                        colorChoose(0);
                    }else{
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring(i,(i + 1)));
                    }
                    farbenlaenge--;
                }
                while (farbenlaenge>0){
                    System.out.print(" ");
                    farbenlaenge--;
                }
            }else{
                for (int i = 0; i < (MainBoerse.speicher.getFahrzeug(array, index).getFarbe().length() - suchText.length()+1); i++) {
                    if (MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring(i, (i + suchText.length())).equals(suchText)) {
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring(0, i));
                        colorChoose(3);// gelb
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring(i, (i + suchText.length())));
                        colorChoose(0);// weiss
                        System.out.print(MainBoerse.speicher.getFahrzeug(array, index).getFarbe().substring((i + suchText.length())));
                        farbenlaenge--;
                    }
                    farbenlaenge--;
                }
                while (farbenlaenge>0){
                    System.out.print(" ");
                    farbenlaenge--;
                }
            }
        }else if(typ == 5){//-------------------------------Preis-------------------------------------------------------
            if (String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).length() == suchText.length()) {
                colorChoose(3);// gelb
                System.out.format("%-17s",MainBoerse.speicher.getFahrzeug(array, index).getPreis());
                colorChoose(0);// weiss
            } else if(suchText.length() == 1) {// check bei nur einem Buchstaben
                for(int i = 0; i < String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).length(); i++){
                    if(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(i,(i + 1)).equals(suchText)){
                        colorChoose(3);
                        System.out.print(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(i,(i + 1)));
                        colorChoose(0);
                    }else{
                        System.out.print(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(i,(i + 1)));
                    }
                    preislaenge--;
                }
                while (preislaenge>0){
                    System.out.print(" ");
                    preislaenge--;
                }
            }else{
                int doppelcheck = 0;
                for(int i = 0; i < (String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).length()-suchText.length()+1); i++){

                    if(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(i,(i + suchText.length())).equals(suchText) && doppelcheck == 0){

                        System.out.print(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(0,i));
                        colorChoose(3);
                        System.out.print(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(i,(i + suchText.length())));
                        colorChoose(0);
                        System.out.print(String.valueOf(MainBoerse.speicher.getFahrzeug(array, index).getPreis()).substring(i + suchText.length()));
                        doppelcheck = 1;
                        preislaenge = preislaenge-suchText.length()+1;
                    }
                    preislaenge--;
                }
                while (preislaenge>0){
                    System.out.print(" ");
                    preislaenge--;
                }
            }
        }else if(typ == 6){//------------------------------Rotorblätter-------------------------------------------------
            String rotorblaetter = String.valueOf(((Boot)MainBoerse.speicher.getFahrzeug(array, index)).getAnzahlRotorBlaetter());
            if(suchText.length()<=4) {
                for (int i = 0; i < rotorblaetter.length(); i++) {
                    if (rotorblaetter.substring(i, i + suchText.length()).equals(suchText)) {
                        colorChoose(0);
                        System.out.print(rotorblaetter.substring(0, i));
                        colorChoose(3);
                        System.out.print(rotorblaetter.substring(i, (i + suchText.length())));
                        colorChoose(0);
                        System.out.print(rotorblaetter.substring((i + suchText.length())));
                        i = i + rotorblaetter.length();
                    }
                }
            }

        }else if(typ == 7){//------------------------------Double Klasse------------------------------------------------
            String klasse = String.valueOf(((Lkw)MainBoerse.speicher.getFahrzeug(array, index)).getKlasse());
            if(suchText.length()<=4) {
                for (int i = 0; i < klasse.length(); i++) {
                    if (klasse.substring(i, i + suchText.length()).equals(suchText)) {
                        colorChoose(0);
                        System.out.print(klasse.substring(0, i));
                        colorChoose(3);
                        System.out.print(klasse.substring(i, (i + suchText.length())));
                        colorChoose(0);
                        System.out.println(klasse.substring((i + suchText.length())));
                        i = i + klasse.length();
                    }
                }
            }
        }else if(typ == 8){//------------------------------Beiwagen-----------------------------------------------------
            for (int i = 0; i < beiwagenSubString.length(); i++){
                if(beiwagenSubString.substring(i,i+suchText.length()).equals(suchText)){
                    System.out.print(beiwagenSubString.substring(0,i));
                    colorChoose(3);
                    System.out.print(beiwagenSubString.substring(i,(i+suchText.length())));
                    colorChoose(0);
                    System.out.print(beiwagenSubString.substring((i+suchText.length())));
                    System.out.println();
                    i = i+beiwagenSubString.length();
                }
            }
        }else if(typ == 9){//--------------------------------Tueren-----------------------------------------------------
            String tueren = String.valueOf(((Pkw)MainBoerse.speicher.getFahrzeug(array, index)).getAnzahlTueren());

            for (int i = 0; i < tueren.length(); i++) {
                if (tueren.substring(i, i + suchText.length()).equals(suchText)) {
                    colorChoose(0);
                    System.out.print(tueren.substring(0, i));
                    colorChoose(3);
                    System.out.print(tueren.substring(i, (i + suchText.length())));
                    colorChoose(0);
                    System.out.println(tueren.substring((i + suchText.length())));
                    i = i + tueren.length();
                }
            }
        }
    }// Ende Sub-String color


    private String[] eingabe = {"Marke","Model","Baujahr","Farbe","Preis","PS","Azahl der Rotorblaetter","Klasse z.B. 3,5","Beiwagen Ja/Nein","anzahl der Türen"};// 10
    int wahl = 0;
    public void sysPrintOut(int index, int mod){
        String anBeSu = "";
        if(mod == 1){
            anBeSu = "anlegen";
        }else if(mod == 2){
            anBeSu = "bearbeiten";
        }else if(mod == 3){
            anBeSu = "suchen";
        }else if(mod == 4) {
            anBeSu = "loeschen";
        }else{
            wahl = mod-5;
        }

        switch (index){
            case 1: System.out.println("\u001B[31mFehlerhafte Eingabe!");
                break;
            case 2: System.out.println("--------------------------------------------------------------");
                break;
            case 3: System.out.println("Wollen Sie wirklich jetzt schon beenden?  j) beenden  n) nochmal n Runde");
                break;
            case 4: System.out.println("Was fuer ein Fahrzeug moechten Sie "+anBeSu+"?");
                break;
            case 5: System.out.println("1) Boot     2) Lkw      3) Motorrad     4) Pkw");
                break;
            case 6: System.out.println("Wollen Sie noch ein Fahrzeug "+anBeSu+" (wenn nicht gehts zum Hauptmenue)?  j/n");
                break;
            case 7: System.out.println("Welches Fahrzeug wollen Sie bearbeiten?  Bitte ID eingeben!");
                break;
            case 8: System.out.println("Welches Fahrzeug wollen Sie loeschen?  Bitte ID eingeben!");
                break;
            case 9: System.out.println("Bitte "+eingabe[wahl]+" eingeben!");
                break;
            case 10: System.out.println("Die Datenbank ist leer!");
                break;
            case 11: System.out.println("Haste deine Brille vergessen? Schau mal richtig hin, es gibt nur "+MainBoerse.speicher.anzahlKfzGesamt()+" Fahrzeuge!!!");
                break;
            case 12: System.out.println("Haha, haben wir n Scherz gemacht?!?! ;-)");
                break;
            case 13: System.out.println("Bitte einen Suchbegriff eingeben!");
                break;
            case 14: System.out.println("Leider ergab Ihre Suche keinen Treffer! Viel Glück beim naechsten MAl!!");
                break;
            case 15: System.out.println("Sind Sie sicher das sie dieses schoene Fahrzeug loeschen wollen??  j/n");
                break;
            case 16: System.out.println("Soll das Fahrzeug gespeichert werden?  j/n");
                break;
            case 17: System.out.println("Ihr Fahrzeug konnte nicht angelegt werden, Bitte ueberpruefen Sie Ihre Eingabe!!");
                break;
            case 18: System.out.println("Sie haben Mist eingegeben, so wird das nix!!");
                break;
            case 19: System.out.println("Sie haben eine falsche Auswahl getroffen!!");
                break;
            case 20: System.out.println("Nach welchem Kriterium soll geloescht werden?");// todo ab hier frei
                break;
            case 21: System.out.println("Aenderung in DB gespeichert!");
                break;
            case 22: System.out.println("Aenderung verworfen!");
                break;
            case 23: System.out.println("Wie viele Autos sollen erstellt werden?");
                break;
            case 24: System.out.println("\u001B[33mReset --> DB wurde neu mit +datenbank.anzahlAutos()+ Autos erstellt!");
                break;
            case 25: System.out.println("Auf Wiedersehen, Einen schoenen Tag noch!");
                break;
        }
    }// Ende Sys-Print-out
    // Farbe verändern:  https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public void colorChoose(int color){
        switch (color) {
            case 0 -> System.out.print("\u001B[0m");// white
            case 1 -> System.out.print("\u001B[31m");// red
            case 2 -> System.out.print("\u001B[34m");// blue
            case 3 -> System.out.print("\u001B[33m");// yellow
            case 4 -> System.out.print("\u001B[30m");// black
            case 5 -> System.out.print("\u001B[32m");// green
            case 6 -> System.out.print("\u001B[35m");// purple
            case 7 -> System.out.print("\u001B[36m");// cyan
            case 8 -> System.out.print("\u001B[37m");// white
            case 9 -> System.out.print("\u001B[40m");// back black
            case 10 -> System.out.print("\u001B[41m");// back red
            case 11 -> System.out.print("\u001B[42m");// back green
            case 12 -> System.out.print("\u001B[43m");// back yellow
            case 13 -> System.out.print("\u001B[44m");// back blue
            case 14 -> System.out.print("\u001B[45m");// back purple
            case 15 -> System.out.print("\u001B[46m");// back cyan
            case 16 -> System.out.print("\u001B[47m");// back white
        }
    }// Ende color change

    /*


    double disaster


    if()

                System.out.print(" Klasse: " );
                colorChoose(3);// Gelb



                String klasse = String.valueOf(((Lkw) MainBoerse.speicher.getFahrzeug(1,liste)).getKlasse());
                if (klasse.length() == doubleSuchString.length()){
                    colorChoose(3);// gelb
                    System.out.println(" Klasse: " + ((Lkw) MainBoerse.speicher.getFahrzeug(1, liste)).getKlasse());
                }else{
                    subStringColor(array, liste,zeichenkette,5);
                }







if(stringSuche) {
            System.out.print("Nr: " + nr);
            if(MainBoerse.speicher.getFahrzeug(array, liste).getMarke().contains(zeichenkette)){
                System.out.print(" Marke: ");
                colorChoose(3);
                System.out.print(MainBoerse.speicher.getFahrzeug(array, liste).getMarke());
                colorChoose(0);
            }else{
                System.out.print(" Marke: " + MainBoerse.speicher.getFahrzeug(array, liste).getMarke());
            }
            if(MainBoerse.speicher.getFahrzeug(array, liste).getModell().contains(zeichenkette)){
                System.out.print(" Modell: ");
                colorChoose(3);
                System.out.print(MainBoerse.speicher.getFahrzeug(array, liste).getModell());
                colorChoose(0);

            }else{
                System.out.print(" Modell: " + MainBoerse.speicher.getFahrzeug(array, liste).getModell());
            }
            System.out.print(" Baujahr: " + MainBoerse.speicher.getFahrzeug(array, liste).getBaujahr());
            if(MainBoerse.speicher.getFahrzeug(array, liste).getFarbe().contains(zeichenkette)){
                System.out.print(" Farbe: ");
                colorChoose(3);
                System.out.print(MainBoerse.speicher.getFahrzeug(array, liste).getFarbe());
                colorChoose(0);
            }else{
                System.out.print(" Farbe: " + MainBoerse.speicher.getFahrzeug(array, liste).getFarbe());
            }
        }else {
            System.out.print("Nr: " + nr + " Marke: " + MainBoerse.speicher.getFahrzeug(array, liste).getMarke() + " " +
                    "Modell " + MainBoerse.speicher.getFahrzeug(array, liste).getModell() + " " +
                    "Baujahr: " + MainBoerse.speicher.getFahrzeug(array, liste).getBaujahr() + " " +
                    "Farbe: " + MainBoerse.speicher.getFahrzeug(array, liste).getFarbe());
        }
        if(preisSuche){

        }













    System.out.print("Nr: " + nr + " Marke: " + MainBoerse.speicher.getFahrzeug(array, liste).getMarke() + " " +
                    "Modell " + MainBoerse.speicher.getFahrzeug(array, liste).getModell() + " " +
                    "Baujahr: " + MainBoerse.speicher.getFahrzeug(array, liste).getBaujahr() + " " +
                    "Farbe: " + MainBoerse.speicher.getFahrzeug(array, liste).getFarbe() + " " +
                    "Preis: " + MainBoerse.speicher.getFahrzeug(array, liste).getPreis() + " " +
                    "PS: " + MainBoerse.speicher.getFahrzeug(array, liste).getPs() + " ");
     */






}
