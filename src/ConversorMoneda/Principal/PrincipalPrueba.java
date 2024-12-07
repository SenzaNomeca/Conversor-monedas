package ConversorMoneda.Principal;

import ConversorMoneda.Logica.ConvertirMoneda;
import ConversorMoneda.Logica.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class PrincipalPrueba {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido");
        System.out.println("Ingrese el pais de la moneda");
        String monedaOrigen = teclado.nextLine();
        System.out.println("Ahora el valor de la moneda");
        double valorMonedaOrigen = teclado.nextDouble();
        System.out.println("Por favor escriba a que pais quiere convertir");
        String paisDeMoneda = teclado.nextLine();



        String direccion = "https://v6.exchangerate-api.com/v6/387de8648fcbe314bc0627ab/latest/" + paisDeMoneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        //System.out.println(json);

        Gson gson =  new Gson();
        ConvertirMoneda convertirMoneda = gson.fromJson(json,ConvertirMoneda.class);

        Map<String, Double> tasas = convertirMoneda.conversion_rates();
        Moneda moneda =  new Moneda();
        moneda.setCOP(tasas.getOrDefault("COP", 0.0));
        moneda.setARS(tasas.getOrDefault("ARS", 0.0));
        moneda.setBOB(tasas.getOrDefault("BOB", 0.0));
        moneda.setBRL(tasas.getOrDefault("BRL", 0.0));
        moneda.setUSD(tasas.getOrDefault("USD", 0.0));
        moneda.setCLP(tasas.getOrDefault("CLP", 0.0));

        moneda.setConversiones(tasas);



        System.out.println("Tasas de cambio:");
        System.out.println(moneda);











    }
}
