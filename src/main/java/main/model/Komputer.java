package main.model;

import java.math.BigDecimal;

public class Komputer extends Produkt { // klasa Komputer rozszerza klase Produkt, Komputer dziedziczy po produkcie

    private String marka;
    private int ram;

    public String getMarka() {
        return marka;
    }

    public int getRam() {
        return ram;
    }

    public Komputer(){

    }

    //Konstruktor jest potrzebny po to żeby nowo stworzony komputer zapisywał komponenty a potem mógł je wyświetlić
    public Komputer(String nazwa, BigDecimal cena, String marka, int ram) {
        super(nazwa, cena); // wywołuje konstuktor klasy bazowej (Produkt)

        this.nazwa = nazwa;
        this.cena = cena;
        this.marka = marka;
        this.ram = ram;

    }

    // toString jest potrzebny po to żeby otrzymąc tekstową reprezentacje tekstu, skonwertować obiekt na tekst
    @Override
    public String toString() {
        return "Komputer{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", marka='" + marka + '\'' +
                ", ram=" + ram +
                '}';
    }
}
