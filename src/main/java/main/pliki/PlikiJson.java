package main.pliki;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Sklep;

import java.io.File;

public class PlikiJson implements OperacjePlikowe {

    public void zapisz(Sklep sklep) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("Jason.json"), sklep);
    }

    public Sklep wczytaj() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Sklep sklep = mapper.readValue(new File("Jason.json"), Sklep.class);
        return sklep;
    }

}
