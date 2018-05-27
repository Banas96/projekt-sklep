package main.model;

import java.math.BigDecimal;

public class Dron extends Produkt {

    private double zasieg;
    private boolean czyMaKamere;

    public Dron() {
    }

    //Konstruktor jest potrzebny po to żeby nowo stworzony komputer zapisywał komponenty a potem mógł je wyświetlić
    public Dron(String nazwa, BigDecimal cena, double zasieg, boolean czyMaKamere) {
        super(nazwa, cena); // wywołuje konstuktor klasy bazowej (Produkt)
        this.nazwa = nazwa;
        this.cena = cena;
        this.zasieg = zasieg;
        this.czyMaKamere = czyMaKamere;
    }

    @Override
    public String toString() {
        return "Dron{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", zasieg=" + zasieg +
                ", czyMaKamere=" + czyMaKamere +
                '}';
    }

    public double getZasieg() {
        return zasieg;
    }

    public boolean isCzyMaKamere() {
        return czyMaKamere;
    }
}
