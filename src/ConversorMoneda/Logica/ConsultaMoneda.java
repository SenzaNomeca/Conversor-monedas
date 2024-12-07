package ConversorMoneda.Logica;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda buscarMoneda(String NNN){
        String direccion = "https://v6.exchangerate-api.com/v6/387de8648fcbe314bc0627ab/latest/" + NNN;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();



            Gson gson =  new Gson();
            ConvertirMoneda convertirMoneda = gson.fromJson(json,ConvertirMoneda.class);

            Moneda monedaConvertida =  new Moneda();

            monedaConvertida.setConversiones(convertirMoneda.conversion_rates());

            return monedaConvertida;

        }catch (IOException | InterruptedException e){
            throw new RuntimeException("Error al consultar la API: " + e.getMessage(), e);
        }

    }

}
