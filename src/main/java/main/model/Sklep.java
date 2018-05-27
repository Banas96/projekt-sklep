package main.model;

import java.io.Serializable;
import java.util.*;

public class Sklep implements Serializable { // Serializable ta klasa może być zapisana do pliku w postaci binarnej
    // składowe
    private Collection<Produkt> produkty; // tworzy kolekcje produktów
    private String nazwa; // nazwa sklepu

    public Sklep(){

    }
    public Sklep(String nazwa){
        this.produkty = new ArrayList<>(); // tworzy nową ArrayListe dla produktów
        this.nazwa = nazwa;
    }

    // metody
    public void dodaj(Produkt produkt) {
        produkty.add(produkt); // dodaje nowy produkt
    }

    public void usun(long id) {
        Iterator<Produkt> iterator = produkty.iterator(); // z kolekcji produkty pozwalamy obiektowi iterator, przez kolekjcję Produkt
        boolean znaleziono = false; // przypisuje false do tego czy jest taki produkt o podanym id
        while(iterator.hasNext()){ // hasNext() zwraca czy komponent ma następny element
            Produkt produkt = iterator.next(); // pobiera następny element z listy
            if(produkt.getId() == id){
                iterator.remove(); // usuwa produkt
                System.out.println("Usunięto produkt");
                znaleziono = true; // jeśli jest produkt o podanym id to przypisuje wartość true
            }
        }
        if(znaleziono == false){ // jeśli nie ma produktu o podanym id to
            System.out.println("Nie ma produktu o podanym indeksie ");
        }
    }

    public void wyswietlListeProduktów(){
        if(produkty.isEmpty()){
            System.out.println("Nie ma żadnych produktów");
        }else {
            System.out.println("lista produktów to : ");
            for (Produkt czasowa : produkty) {
                System.out.println(czasowa);
            }
        }
    }

    public void wyswietlListePosortowanaPoCenie(){
        if(produkty.isEmpty()){
            System.out.println("Nie ma żadnych produktów");
        }else {
            List<Produkt>kopiaProdukty = new ArrayList<>(produkty); // tworzymy kopie listy, która jest nową listą
            Collections.sort(kopiaProdukty); // sortuje
            System.out.println("lista produktów to : ");
            for (Produkt czasowa : kopiaProdukty) {
                System.out.println(czasowa);
            }

        }
    }

    public Collection<Produkt> getProdukty() {
        return produkty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void wyswietlListePosortowanaPoNazwie(){
        if(produkty.isEmpty()){
            System.out.println("Nie ma żadnych produktów");
        }else {
            Comparator<Produkt> nazwaKomparator = new Comparator<Produkt>() {
                //sortownie po nazwie za pomocą coparatora funkcji compare()
                @Override
                public int compare(Produkt o1, Produkt o2) {
                    if( o1.nazwa.compareTo(o2.nazwa) < 0 ){
                        return -1;
                    }else if( o1.nazwa.compareTo(o2.nazwa) > 0 ){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            };
            List<Produkt>kopiaProdukty = new ArrayList<>(produkty); // tworzymy kopie listy, która jest nową listą
            Collections.sort(kopiaProdukty, nazwaKomparator); // sortuje
            System.out.println("lista produktów to : ");
            for (Produkt czasowa : kopiaProdukty) {
                System.out.println(czasowa);
            }


        }
    }
}
