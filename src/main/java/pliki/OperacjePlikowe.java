package pliki;

import model.Sklep;

public interface OperacjePlikowe {

     void  zapisz(Sklep sklep) throws Exception; // abstract nie ma ciałą

    Sklep wczytaj() throws Exception;

    default void wyswietl() {

    }
}
