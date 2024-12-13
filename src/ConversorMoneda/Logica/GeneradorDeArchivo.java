package ConversorMoneda.Logica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {

    public void guardarTxt(List monedas) throws IOException{

        FileWriter escritura = new FileWriter("RegistroConversiones.txt");
        escritura.write(monedas.toString());
        escritura.close();
    }

}
