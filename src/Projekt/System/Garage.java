package Projekt.System;
import Projekt.Fahrzeuge.*;

import java.util.ArrayList;

public class Garage{
    //-----------------------------------------------Fahrzeugspeicher---------------------------------------------------
    private ArrayList<Fahrzeug>[] speicher = new ArrayList[4];
    //----------------------------------------------KFZ-Speicher-Arrays------------------------------------------------
    private ArrayList<Fahrzeug> boote = new ArrayList<Fahrzeug>();
    private ArrayList<Fahrzeug> trucks = new ArrayList<Fahrzeug>();
    private ArrayList<Fahrzeug> bikes = new ArrayList<Fahrzeug>();
    private ArrayList<Fahrzeug> cars = new ArrayList<Fahrzeug>();

    public void initializeSpeicher(){
        speicher[0]=boote;
        speicher[1]=trucks;
        speicher[2]=bikes;
        speicher[3]=cars;
    }
    //------------------------------------------>Fahrzeug---------------------------------------------------------------
    public void setSpeicher(int type, Fahrzeug vehicle) {
        this.speicher[type].add(vehicle);
    }
    //------------------------------------------Fahrzeug>---------------------------------------------------------------
    public Fahrzeug getFahrzeug(int type,int index){
        return speicher[type].get(index);
    }
    //---------------------------------------laenge einer Liste---------------------------------------------------------
    public int anzahlKfzListe(int type){
        return speicher[type].size();
    }
    //---------------------------------------laenge aller Listen--------------------------------------------------------
    public int anzahlKfzGesamt(){
        return speicher[0].size()+speicher[1].size()+speicher[2].size()+speicher[3].size();
    }
    //--------------------------------------------fzg loeschen----------------------------------------------------------
    public void fzgLoeschen(int type, int id){speicher[type].remove(id);}
}// Ende Garage

