package Projekt.Fahrzeuge;

public class Boot extends Fahrzeug{
    protected int anzahlRotorBlaetter;
    public Boot(){}
    public Boot(String marke, String modell, int baujahr, String farbe, double preis, int ps, int anzahlRotorBlaetter ) {
        super.marke = marke;
        super.modell = modell;
        super.baujahr = baujahr;
        super.farbe = farbe;
        super.preis = preis;
        super.ps = ps;
        this.anzahlRotorBlaetter = anzahlRotorBlaetter;
    }

    public void setAnzahlRotorBlaetter(int rotor){
        anzahlRotorBlaetter = rotor;
    }
    public int getAnzahlRotorBlaetter(){
        return anzahlRotorBlaetter;
    }

}// Ende Boot
