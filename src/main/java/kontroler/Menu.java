package kontroler;

import model.Dron;
import model.Komputer;
import model.Sklep;
import pliki.OperacjePlikowe;
import pliki.PlikiBinarne;
import pliki.PlikiJson;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    public void wyswietlMenu(){
        System.out.println("Podaj sposób zapisu plików");
        System.out.println("1 - binarnie");
        System.out.println("2 - JSON");

        Scanner skaner = new Scanner(System.in); // tworzy nowy skaner

        String wyborPliku = skaner.nextLine();
        OperacjePlikowe pliki;
        switch (wyborPliku){
            case "1":
                pliki = new PlikiBinarne();
                break;
            case "2":
                pliki = new PlikiJson();
                break;
            default:
                pliki = new PlikiBinarne();
                break;
        }

        Sklep sklep;
        try{
            sklep = pliki.wczytaj();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Błąd odczytu, startujemy z pustym sklepem");
            sklep = new Sklep("www.Antoś.com");
        }

        /*odczyt z pliku za pomocą binarnych
        PlikiBinarne plikiBinarne = new PlikiBinarne();
        Sklep sklep = null;
        try{
            sklep = plikiBinarne.wczytaj();
        } catch(Exception e){
            System.out.println("Błąd odczytu, startujemy z pustym sklepem");
            sklep = new Sklep("www.Antoś.com");
        }
*/
        /* odczyt z pliku za pomocą Jsona
        PlikiJson plikiJson = new PlikiJson();
        Sklep sklep;
        try{
            sklep = plikiJson.wczytaj();
        } catch(Exception e){
            System.out.println("Błąd odczytu, startujemy z pustym sklepem");
            sklep = new Sklep("www.Antoś.com");
        }
        */

        System.out.println("Podaj operacje");
        System.out.println("1 Dodaj komputer");
        System.out.println("2 Dodaj dron");
        System.out.println("3 Usuń produkt");
        System.out.println("4 Wyświetl liste produktów");
        System.out.println("5 Wyświetl liste posortowaną po nazwie");
        System.out.println("6 Wyświetl liste posortowaną po cenie");
        System.out.println("q Wyjdź");

        String wybor;
        do {
            wybor = skaner.nextLine(); //wczyta wybor użytkownika, next czyta wszystko do spacji lub entera a nextLine() wszystko
            switch (wybor) {
                case "1":
                    // wczyta informacje o produkcie
                    System.out.println("Podaj nazwe");
                    String nazwa = skaner.next();
                    System.out.println("Podaj cene");
                    BigDecimal cena = skaner.nextBigDecimal();
                    System.out.println("Podaj marke");
                    String marka = skaner.next();
                    System.out.println("Podaj ilośc RAM");
                    int ram = skaner.nextInt(); // 3,45\n nextInt zostawia w buforze znak nowej linii
                    skaner.nextLine(); // skaner.NextLine() czyści znak nowej linii, żeby kolejna instrukcja nie przeczytała pustego znaku
                    Komputer nowyKomputer = new Komputer( nazwa,  cena,  marka, ram); // stworzy obiekt typu Komputer, ważne jest żeby wypisać wszystkie składowe
                    sklep.dodaj(nowyKomputer); // wywoła metode klasy sklep
                    System.out.println("Dodano nowy komputer");
                    break; // kończy case'a
                case "2":
                    // wczyta informacje o produkcie
                    System.out.println("Podaj nazwe");
                    nazwa = skaner.next();
                    System.out.println("Podaj cene");
                    cena = skaner.nextBigDecimal();
                    System.out.println("Podaj zasięg");
                    double zasieg = skaner.nextDouble();
                    System.out.println("Czy ma kamerę True / False");
                    String czyMaKamere = skaner.next();
                    while(!czyMaKamere.equalsIgnoreCase("true") && !czyMaKamere.equalsIgnoreCase("false")){ //rób tak długo, aż nie będzie true i false bez względu na wielkość liter
                        System.out.println("Podaj prawidłową wartość");
                        czyMaKamere = skaner.next();
                    }
                    Dron nowyDron = new Dron(nazwa, cena, zasieg, Boolean.parseBoolean(czyMaKamere)); // stworzy obiekt typu Dron, ważne jest żeby wypisać wszystkie składowe, parsowanie Stringa na Booleana
                    sklep.dodaj(nowyDron); // wywoła metode klasy sklep
                    System.out.println("Dodano nowy dron");
                    skaner.nextLine();
                    break;
                case "3":
                    System.out.println("Podaj id do usunięcia");
                    long id = skaner.nextLong(); // wczyta id produktu, który chce usunąć
                    skaner.nextLine(); // skaner.NextLine() czyści znak nowej linii, żeby kolejna instrukcja nie przeczytała pustego znaku
                    sklep.usun(id); // wywoła metode klasy sklep
                    break; // kończy case'a
                case "4":
                    sklep.wyswietlListeProduktów(); // wywoła metode klasy Sklep
                    break; // kończy case'a
                case "5":
                    sklep.wyswietlListePosortowanaPoNazwie(); // wywoła metode klasy Sklep
                    break; // kończy case'a
                case "6":
                     sklep.wyswietlListePosortowanaPoCenie(); // wywoła metode klasy Sklep
                    break; // kończy case'a
                case "q":
                    System.out.println("Koniec");
                    try{
                        pliki.zapisz(sklep); //zapis do pliku
                    }catch(Exception e){
                        System.out.println("Błąd zapisu do pliku");
                        System.out.println("Czy chcesz zakończyc program nie zapisując go ? True / False");
                        Boolean czyZakonczyc = false;
                        czyZakonczyc = skaner.nextBoolean();
                        e.printStackTrace();
                        if(czyZakonczyc){ // jeśli true
                            return; // kończy cała funkcje
                        }
                        else{
                        break; // kończy case'a
                        }
                    }
                default: // jeśli wpiszesz inną opcje niż podane to
                    System.out.println("Nie ma takiej operacji");
                    break; // kończy cała funkcje
            }
            System.out.println();
            System.out.println("Podaj nową operacje");
        }while(!wybor.equalsIgnoreCase("q")); // zaprzeczenie equalsIgnoreCase, rób tak długo póki to co wpisujesz jest inne niż "q"
        // equalsIgnoreCase rób tak długo póki ( "to") jest prawdziwe
    }
}
