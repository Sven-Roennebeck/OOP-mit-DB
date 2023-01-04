package Projekt.Service;

import Projekt.MainBoerse;
import Projekt.System.Printer;

public class InputVar extends Printer {// extendet in --> Hersteller und Werkstatt
    // Einziger Ort wo diese Variablen erstellt wurden
    private String marke;
    private String model;
    private int baujahr;
    private String farbe;
    private double preis;
    private int ps;
    private int propeller;
    private double klasse;
    private boolean beiwagen;
    private int tueren;

    //---------------------Klasse Vererbt an Fahrzeug-Hersteller und Werkstatt------------------------------------------
    // somit ist die eingabe der Variablen mit nur eimaliger deklaration in beiden Klassen möglich

    public void eingabeDaten(int typ,int mod) {

        sysPrintOut(9, 5);
        marke = MainBoerse.handling.validate.inputString(0,mod);// <-- Marke
        sysPrintOut(9, 6);
        model = MainBoerse.handling.validate.inputString(0,mod);// <-- Model
        sysPrintOut(9, 7);// <-- Baujahr
        baujahr = MainBoerse.handling.validate.inputInt(mod);
        sysPrintOut(9, 8);// <-- Farbe
        farbe = MainBoerse.handling.validate.inputString(0,mod);
        sysPrintOut(9, 9);// <-- Preis
        preis = MainBoerse.handling.validate.inputDouble(mod);
        sysPrintOut(9, 10);// <-- PS
        ps = MainBoerse.handling.validate.inputInt(mod);

        switch (typ){// je nach typ zusatz eingeben
            case 0 -> {sysPrintOut(9, 11);
                propeller = MainBoerse.handling.validate.inputInt(mod);}// <-- anzahl Rotorblätter
            case 1 -> {sysPrintOut(9, 12);
                klasse = MainBoerse.handling.validate.inputDouble(mod);}// <-- Klasse
            case 2 -> {sysPrintOut(9, 13);
                beiwagen = MainBoerse.handling.validate.inputJaNein(mod);}// <-- Beiwagen
            case 3 -> {sysPrintOut(9, 14);
                tueren = MainBoerse.handling.validate.inputInt(mod);}// <-- Anzahl Türen
        }
    }// Ende Eingabe Daten
    //-------------------------------------------------getter-----------------------------------------------------------
    public String getMarke() {
        return marke;
    }

    public String getModel() {
        return model;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public String getFarbe() {
        return farbe;
    }

    public double getPreis() {
        return preis;
    }

    public int getPs() {
        return ps;
    }

    public int getPropeller() {
        return propeller;
    }

    public double getKlasse() {
        return klasse;
    }

    public boolean isBeiwagen() {
        return beiwagen;
    }

    public int getTueren() {
        return tueren;
    }
}// Ende Producer
