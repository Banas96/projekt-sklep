package pliki;

import model.Sklep;

import java.io.*;

public class PlikiBinarne implements OperacjePlikowe {

    // InputStream i OutputStream - pliki binarne
    // Reader (Scanner), Writer - pliki tekstowe

    public void zapisz(Sklep sklep) throws IOException { // wyjątek wejścia/wyjścia
        FileOutputStream fos = new FileOutputStream("sklep.bin"); // tworzy nowy obiekt
        ObjectOutputStream ous = new ObjectOutputStream(fos); // żeby miał więcej metod
        ous.writeObject(sklep); // zamienia sklep na bajty i zapisuje w pliku "sklep.bin"
        ous.close(); // zamyka strumień
        fos.close(); // zamyka strumień
    }

    public Sklep wczytaj() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("sklep.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Sklep sklep = (Sklep) ois.readObject(); // rzutowanie na Sklep
        ois.close(); // zamyka strumień
        fis.close(); // zamyka strumień
        return sklep;
    }
}
