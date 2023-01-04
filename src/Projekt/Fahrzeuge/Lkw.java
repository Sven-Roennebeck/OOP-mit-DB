package Projekt.Fahrzeuge;

public class Lkw extends Fahrzeug{
    protected double klasse;
    public Lkw(String marke, String modell,int baujahr, String farbe, double preis, int ps, double klasse) {
        super.marke = marke;
        super.modell = modell;
        super.baujahr = baujahr;
        super.farbe = farbe;
        super.preis = preis;
        super.ps = ps;
        this.klasse = klasse;

    }

    public void setKlasse(double klasse){
        this.klasse = klasse;
    }
    public double getKlasse(){
        return klasse;
    }

}
