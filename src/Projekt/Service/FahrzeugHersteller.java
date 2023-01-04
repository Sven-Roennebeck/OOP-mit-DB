package Projekt.Service;

import Projekt.Fahrzeuge.Boot;
import Projekt.Fahrzeuge.Lkw;
import Projekt.Fahrzeuge.Motorrad;
import Projekt.Fahrzeuge.Pkw;
import Projekt.MainBoerse;


public class FahrzeugHersteller{

    public void producer(int typ){

        MainBoerse.eingabe.eingabeDaten(typ,0);// Eingabefür entspechendes Fahrzeug aufrufen

        switch (typ){
            case 0 -> {
                MainBoerse.speicher.setSpeicher(0, new Boot(MainBoerse.eingabe.getMarke(), MainBoerse.eingabe.getModel(), MainBoerse.eingabe.getBaujahr() , MainBoerse.eingabe.getFarbe(), MainBoerse.eingabe.getPreis(), MainBoerse.eingabe.getPs(), MainBoerse.eingabe.getPropeller()));}
            case 1 -> {
                MainBoerse.speicher.setSpeicher(1, new Lkw(MainBoerse.eingabe.getMarke(), MainBoerse.eingabe.getModel(), MainBoerse.eingabe.getBaujahr() , MainBoerse.eingabe.getFarbe(), MainBoerse.eingabe.getPreis(), MainBoerse.eingabe.getPs(), MainBoerse.eingabe.getKlasse()));}
            case 2 -> {
                MainBoerse.speicher.setSpeicher(2, new Motorrad(MainBoerse.eingabe.getMarke(), MainBoerse.eingabe.getModel(), MainBoerse.eingabe.getBaujahr() , MainBoerse.eingabe.getFarbe(), MainBoerse.eingabe.getPreis(), MainBoerse.eingabe.getPs(), MainBoerse.eingabe.isBeiwagen()));}
            case 3 -> {
                MainBoerse.speicher.setSpeicher(3, new Pkw(MainBoerse.eingabe.getMarke(), MainBoerse.eingabe.getModel(), MainBoerse.eingabe.getBaujahr() , MainBoerse.eingabe.getFarbe(), MainBoerse.eingabe.getPreis(), MainBoerse.eingabe.getPs(), MainBoerse.eingabe.getTueren()));}
        }

        MainBoerse.handling.secondUse = 1;
        MainBoerse.handling.kfzHandling(1);// --> anlegen

    }// Ende Producer
}// Ende FahrzeugHersteller
