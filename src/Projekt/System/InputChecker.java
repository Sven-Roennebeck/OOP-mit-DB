package Projekt.System;

import Projekt.MainBoerse;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputChecker extends Printer{
    private Scanner inputChecker = new Scanner(System.in);
    private int intNummer;
    private double doubleNummer;
    private String zeichenkette;
    //------------------------------------------Integer Input-----------------------------------------------------------
    public int inputInt(int exitVar){// exitVar definiert den ausstieg bei falscheingabe
        String zahlenEingabe = inputString(0,exitVar);
        if(!checkInt(zahlenEingabe)){
            exitToMenue(exitVar);
        }else{
            intNummer =Integer.parseInt(zahlenEingabe);
        }
        return intNummer;
    }// Ende Int Fehleingabe
    //------------------------------------------Double Input------------------------------------------------------------
    public double inputDouble(int exitVar){// exitVar definiert den ausstieg bei falscheingabe
        inputChecker = new Scanner(System.in);
        String doubleInput = inputChecker.nextLine();// als String einlesen
        if(!checkDouble(doubleInput)){
            exitToMenue(exitVar);
        }else {
            if (doubleInput.contains(",")) {
                doubleInput = doubleInput.replace(",", ".");// Komma gegen Punkt tauschen
            }
            doubleNummer = Double.parseDouble(doubleInput);// String in double parsen
        }
        return doubleNummer;
    }// Ende Double Fehleingabe
    //---------------------------------------------String Eingabe-------------------------------------------------------
    public String inputString(int uppercase, int exitVar){// exitVar definiert den ausstieg bei falscheingabe
        inputChecker = new Scanner(System.in);
        if(uppercase == 0) {
            zeichenkette = inputChecker.nextLine();
        }else{
            zeichenkette = inputChecker.nextLine().toUpperCase();
        }
        if(zeichenkette.equals("")){
            MainBoerse.handling.secondUse = 0;
            exitToMenue(exitVar);
        }
        return zeichenkette;
    }
    //---------------------------------------------Ja/Nein Eingabe------------------------------------------------------
    public boolean inputJaNein(int exitVar){
        boolean jaNein = false;
        boolean checkCheck = false;
        String[] ja = {"j","J","ja","Ja","JA","true","tr","TR","t","T"};
        String[] nein = {"n","N","nein","Nein","false","f","F"};
        inputChecker = new Scanner(System.in);
        String jaNeinEingabe = inputChecker.nextLine();
        for(String checkJ:ja){

            if(jaNeinEingabe.equals(checkJ)){
                jaNein = true;
                checkCheck = true;
            }
        }
        for (String checkN:nein){

            if(jaNeinEingabe.equals(checkN)){
                jaNein = false;
                checkCheck = true;
            }
        }
        if(!checkCheck){
            exitToMenue(exitVar);
        }
        return jaNein;
    }
    //-----------------------------------------wohin solls gehen bei Mist eingabe---------------------------------------
    private void exitToMenue(int exitVar){
        colorChoose(3);// gelb
        if(exitVar==0){// --> aus anlegen
            sysPrintOut(17,0);// konnte nicht angelegt werden
            MainBoerse.handling.falschEingabe();
        }else if(exitVar == 1){// --> aus bearbeiten
            sysPrintOut(18,0);// das wird nix
            MainBoerse.handling.secondUse = 1;
            MainBoerse.handling.kfzHandling(2);
        }else if(exitVar == 3){
            sysPrintOut(19,0);// Falsche Auswahl
            MainBoerse.handling.secondUse = 1;
            MainBoerse.handling.kfzHandling(2);
        }else{
            MainBoerse.handling.falschEingabe();
        }
    }
    //------------------------------------------gusi bekar ajedah rusi--------------------------------------------------
    private String[] zeichen = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","ß","?",".","-","/","_",",",";","!","§","$","&","(",")","=","`","´","*","+","#","'",":"," ","<",">","^","°","\"",":",";","_","~","´","`","}","{","]","[","|"};
    private boolean checkZeichen(String zeichenkette){
        boolean checkZeichen = false;
        for(int i = 0; i<zeichen.length;i++){
            if(zeichenkette.contains(zeichen[i])){
                checkZeichen = true;
            }
            if(zeichenkette.contains(zeichen[i].toUpperCase())){
                checkZeichen = true;
            }
        }
        return checkZeichen;
    }
    //-----------------------------------------------Integer check------------------------------------------------------
    private String[] zahlen = {"0","1","2","3","4","5","6","7","8","9",".",","};
    private boolean checkInt(String zeichenkette){
        boolean checkInt = false;
        int checkEveryChar = 0;
        for(int i = 0; i < zeichenkette.length(); i++) {
            for (int e = 0; e < (zahlen.length-2); e++) {
                if (zeichenkette.substring(i,i+1).equals(zahlen[e])) {
                    checkEveryChar++;
                }
            }
        }
        if(checkEveryChar == zeichenkette.length()){
            checkInt = true;
        }else{
            checkInt = false;
        }
        return checkInt;
    }
    //----------------------------------------------Double eingabe check------------------------------------------------
    private boolean checkDouble(String zeichenkette){
        boolean checkDouble = false;
        int checkEveryChar = 0;
        int countKomma = 0;
        int countPunkt = 0;
        for(int i = 0; i < zeichenkette.length(); i++) {
            for (int e = 0; e < zahlen.length; e++) {
                if (zeichenkette.substring(i,i+1).equals(zahlen[e])) {
                    if(zeichenkette.substring(i,i+1).equals(".")){
                        countPunkt++;
                    }
                    if(zeichenkette.substring(i,i+1).equals(",")){
                        countKomma++;
                    }
                    checkEveryChar++;
                }
            }
        }
        if((countKomma + countPunkt) > 1){// wenn mehr als ein trennzeichen eingegeben wurde
            checkDouble = false;
        }else if(checkEveryChar == zeichenkette.length()){
            checkDouble = true;
        }else{
            checkDouble = false;
        }
        return checkDouble;
    }
    //---------------------------------------------------Suchbegriff----------------------------------------------------
    // Eingabe-String auf enthaltene Zeichen überprüfen
    public void suchbegriff(){

        inputChecker = new Scanner(System.in);
        zeichenkette = inputChecker.nextLine();

        if(zeichenkette.equals("")){// Fehlerabfang bei eingabe mit nix
            exitToMenue(4);
        }else if(zeichenkette.equals("Boot")){
            merkmal = 2;
            printOut(0,0);
        }else if(zeichenkette.equals("Lkw")){
            merkmal = 2;
            printOut(1,0);
        }else if(zeichenkette.equals("Motorrad")){
            merkmal = 2;
            printOut(2,0);
        }else if(zeichenkette.equals("Pkw")){
            merkmal = 2;
            printOut(3,0);
        }else if(zeichenkette.equals("nico") || zeichenkette.equals("Nico")){
            for (int i = 0;i < 4; i++){
                printOut(i,1);
            }
        }else{
            merkmal = 1;
            MainBoerse.handling.schnueffler.setSuchString(zeichenkette);
        }
    }// Ende Suchbegriff
}// Ende Input Checker
