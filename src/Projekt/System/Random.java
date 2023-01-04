package Projekt.System;

import Projekt.MainBoerse;
import Projekt.Fahrzeuge.*;

public class Random {

    // Variablen aus Fahrzeugklassen
    private String[] pkwMarke = {"Audi","BMW","Maserati","VW","Mercedes","SAAB","Opel","Skoda","Ford",
            "Wartburg","Porsche","Tesla","Renault","Honda","Trabant","Hyundai","Jaguar","DeLorean"};//14
    private String[] lkwMarke = {"Scania","Isuzu","Tata","Shaanxi","Paccar","CNHTC","Volvo","Dongfeng","MAN","Daimler","DAF"};// 11
    private String[] motorradMarke = {"Honda","Yamaha","BMW","Suzuki","Kawasaki","Vespa/Piaggio","KTM","Harley-Davidson","Ducati","Triumph","Husqvarna"};// 11
    private String[] bootMarke = {"Sunseeker","Azimut Yachts","Najad","Hanse","Sea Ray","Sealine","Hallberg-Rassy",
            "Princess","Bavaria Yachts","Bayliner","Beneteau","Nimbus","Fairline","Sunbeam",
            "Elan","Quiksilver","Dufour Yachts",};// 17
    private String[] modell = {"X-12","0815","Spezial","Normalo","Turbo","Wuehlmaus","Marder","Family","Getz"};// 8
    private int baujahr;
    private int firstYear = 1980;
    private int lastYear = 2022;
    private String[] farbe = {"rot","blau","gruen","gelb","rosa","pink","lila","schwarz","weiss","grau","orange"};// 11;
    private double preis;
    private double preisMax = 50000.34;
    private double preisMin = 1000.67;
    private int[] ps = {45,65,75,80,120,180,200,220,330,550};//10
    int hp;

    // Variablen aus Boot
    private int[] anzahlRotorBlaetter = {3,5,8,9,12};// 5
    // Variablen aus Lkw
    private double[] klasse = {3.5,7.5,12.0,30.0,40.0};// 5

    // Variablen aus Motorrad
    private boolean beiwagen;


    // Variablen aus Pkw
    int tueren;
    int tuerenMax = 5;
    int tuerenMin = 1;


    public void randomFahrzeuge(int anzahl) {
        // Typ generieren
        int typ = 0;
        String marke = "";
        String model = "";
        String color = "";


        // gemeinsame Werte für Dummys generieren
        for(;anzahl > 0; anzahl--) {
            typ = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
            switch (typ){
                case 0 -> marke = bootMarke[(int) Math.floor(Math.random() * ((bootMarke.length-1) - 0 + 1) + 0)];
                case 1 -> marke = lkwMarke[(int) Math.floor(Math.random() * ((lkwMarke.length-1) - 0 + 1) + 0)];
                case 2 -> marke = motorradMarke[(int) Math.floor(Math.random() * ((motorradMarke.length-1) - 0 + 1) + 0)];
                case 3 -> marke = pkwMarke[(int) Math.floor(Math.random() * ((pkwMarke.length-1) - 0 + 1) + 0)];
            }// Ende Marke Random

            model = modell[(int) Math.floor(Math.random() * ((modell.length-1) - 0 + 1) + 0)];
            baujahr = (int) Math.floor(Math.random() * (lastYear - firstYear + 1) + firstYear);
            color = farbe[(int) Math.floor(Math.random() * ((farbe.length-1) - 0 + 1) + 0)];
            preis = Math.floor(Math.random() * (preisMax - preisMin + 1) + preisMin);
            hp = ps[(int) Math.floor(Math.random() * ((ps.length-1) - 0 + 1) + 0)];

            // Umleitung zu entsprechender Mathode
            switch (typ) {
                case 0 -> bootAnlegen(marke,model,baujahr, color,preis,hp);
                case 1 -> lkwAnlegen(marke,model,baujahr, color,preis,hp);
                case 2 -> motorradAnlegen(marke,model, baujahr, color,preis,hp);
                case 3 -> pkwAnlegen(marke,model,baujahr ,color,preis,hp);
            }
        }
    }// Ende Generator



    //todo--------------------------------------einzel werte der klassen generieren
    private void bootAnlegen(String marke,String model,int baujahr, String color,double preis,int hp){
        int propeller = anzahlRotorBlaetter[(int) Math.floor(Math.random() * ((anzahlRotorBlaetter.length-1) - 0 + 1) + 0)];
        MainBoerse.speicher.setSpeicher(0, new Boot(marke, model, baujahr , color, preis, hp, propeller));
        //System.out.print("Boot ");
    }
    private void lkwAnlegen(String marke,String model,int baujahr,String color,double preis,int hp){
        double tonnage = klasse[(int) Math.floor(Math.random() * ((klasse.length-1) - 0 + 1) + 0)];
        MainBoerse.speicher.setSpeicher(1, new Lkw(marke, model, baujahr , color, preis, hp, tonnage));
        //System.out.print("Lkw ");
    }
    private void motorradAnlegen(String marke,String model,int baujahr, String color,double preis,int hp){
        int jaOderNein = (int) Math.floor(Math.random() * (100 - 0 + 1) + 0);
        if(jaOderNein%2==0){
            beiwagen = true;
        }else{
            beiwagen = false;
        }
        MainBoerse.speicher.setSpeicher(2, new Motorrad(marke, model, baujahr , color, preis, hp,beiwagen));
        //System.out.print("Motorrad ");
    }
    private void pkwAnlegen(String marke,String model, int baujahr,String color,double preis,int hp){
        tueren =(int) Math.floor(Math.random() * (tuerenMax - tuerenMin + 1) + tuerenMin);
        MainBoerse.speicher.setSpeicher(3, new Pkw(marke, model, baujahr , color, preis, hp,tueren));
        //System.out.print("Pkw ");
    }
}// Ende Random
