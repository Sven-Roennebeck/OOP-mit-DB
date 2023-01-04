package Projekt.Fahrzeuge;
public class Pkw extends Fahrzeug{
    protected int anzahlTueren;

    public Pkw(String marke, String modell, int baujahr, String farbe, double preis, int ps, int anzahlTueren) {
        super.marke = marke;
        super.modell = modell;
        super.baujahr = baujahr;
        super.farbe = farbe;
        super.preis = preis;
        super.ps = ps;
        this.anzahlTueren = anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTueren){
        this.anzahlTueren = anzahlTueren;
    }
    public int getAnzahlTueren(){
        return anzahlTueren;
    }


}
