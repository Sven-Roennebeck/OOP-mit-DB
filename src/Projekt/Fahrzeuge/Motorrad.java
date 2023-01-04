package Projekt.Fahrzeuge;

public class Motorrad extends Fahrzeug{
    private boolean beiwagen;

    public Motorrad(String marke, String modell, int baujahr, String farbe, double preis, int ps, boolean beiwagen) {
        super.marke = marke;
        super.modell = modell;
        super.baujahr = baujahr;
        super.farbe = farbe;
        super.preis = preis;
        super.ps = ps;
        this.beiwagen = beiwagen;

    }
    public void setBeiwagen(boolean beiwagen){
        this.beiwagen = beiwagen;
    }
    public boolean isBeiwagen(){
        return beiwagen;
    }

}// Ende Motorrad
