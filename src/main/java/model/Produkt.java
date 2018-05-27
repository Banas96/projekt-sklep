package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typ")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Komputer.class, name = "komputer"),
        @JsonSubTypes.Type(value = Dron.class, name = "dron"),
}
)

public abstract class Produkt implements Comparable <Produkt>, Serializable {
    protected long id; // protected jest publiczna dla klas dziedziczących i prywatna dla pozostałych
    protected String nazwa;
    protected BigDecimal cena; // dokładna wartość , zawsze zapisujemy ją do cen, piszemy z jaką dokładnością chcemy otrzymać liczbę
    private static long generatorId = 0L; // static daje nam, że będzie tylko jedno takie id

    public Produkt(String nazwa, BigDecimal cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        generatorId++; // zwiększa generator o 1 w góre i zachowuje jego wartość w polu id
        this.id = generatorId; // każde następne id dostanie wartość o jeden większą
    }

    public Produkt(){

    }
    public long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    // sortowanie po cenie za pomocą interfejsu Comparable funkcji CompareTo()
    @Override
    public int compareTo(Produkt o) {
        if( this.cena.compareTo(o.cena) < 0 ){
            return -1;
        }else if( this.cena.compareTo(o.cena) > 0 ){
            return 1;
        }else {
            return 0;
        }
    }
}
