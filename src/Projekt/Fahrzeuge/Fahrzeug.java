package Projekt.Fahrzeuge;

public abstract class Fahrzeug{
    protected String marke;
    protected String modell;
    protected int baujahr;
    protected String farbe;
    protected double preis;
    protected int ps;

    //-------------------------------------------------setter-----------------------------------------------------------
    public void setMarke(String marke){
        this.marke = marke;
    }

    public void setModell(String modell){
        this.modell = modell;
    }

    public void setBaujahr(int baujahr) { this.baujahr = baujahr;}

    public void setFarbe(String farbe){
        this.farbe = farbe;
    }

    public void setPreis(double preis){
        this.preis = preis;
    }
    public void setPs(int ps){
        this.ps = ps;
    }
    //-------------------------------------------------getter-----------------------------------------------------------

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {return baujahr;}

    public String getFarbe() {
        return farbe;
    }

    public double getPreis() {
        return preis;
    }
    public int getPs(){
        return ps;
    }
}// Ende Projekt.Fahrzeuge.Fahrzeug
