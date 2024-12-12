package ConversorMoneda.Logica;

import java.util.Map;
import java.util.Scanner;

public class Moneda {
    private double COP;
    private double ARS;
    private double BOB;
    private double BRL;
    private double USD;
    private double CLP;
    private Map<String, Double> conversiones;

    // Getters y setters
    public double getCOP() {
        return COP;
    }

    public void setCOP(double COP) {
        this.COP = COP;
    }

    public double getARS() {
        return ARS;
    }

    public void setARS(double ARS) {
        this.ARS = ARS;
    }

    public double getBOB() {
        return BOB;
    }

    public void setBOB(double BOB) {
        this.BOB = BOB;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getCLP() {
        return CLP;
    }

    public void setCLP(double CLP) {
        this.CLP = CLP;
    }

    public Map<String, Double> getConversiones() {
        return conversiones;
    }

    public void setConversiones(Map<String, Double> conversiones) {
        this.conversiones = conversiones;
    }

    public double getValorPorCodigo(String currencyCode) {
        if (conversiones != null && conversiones.containsKey(currencyCode)) {
            return conversiones.get(currencyCode);
        }
        return 0.0;
    }

    public double convertir(String monedaDestino, double cantidadOrigen) {
        if (conversiones == null || !conversiones.containsKey(monedaDestino)) {
            throw new IllegalArgumentException("La conversión no está disponible para la moneda destino: " + monedaDestino);
        }
        return cantidadOrigen * conversiones.get(monedaDestino);
    }

    public static double pedirValorMoneda(Scanner teclado, String monedaOrigen, String monedaDestino){
        System.out.println("Ingrese la cantidad de " + monedaOrigen + " que desea convertir a " + monedaDestino + ":");
        double cantidadOrigen = teclado.nextDouble();

        if(cantidadOrigen <= 0.0){
            System.out.println("Profavor, ingrese un valor mayor a 0");
            return pedirValorMoneda(teclado, monedaOrigen, monedaDestino);
        }
        return cantidadOrigen;
    }

    public static double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidadOrigen, ConsultaMoneda consulta) {
        Moneda monedaAConsultar = consulta.buscarMoneda(monedaOrigen);

        if (monedaAConsultar == null) {
            System.out.println("Moneda no encontrada, disculpe.");
            return 0.0;
        }

        try {
            double tasaDestino = monedaAConsultar.getValorPorCodigo(monedaDestino);
            if (tasaDestino == 0.0) {
                System.out.println("La conversión no está disponible para este caso.");
                return 0.0;
            }
                double resultado = monedaAConsultar.convertir(monedaDestino, cantidadOrigen);
                System.out.println("El valor de " + cantidadOrigen + " " + monedaOrigen + " convertido a " +
                        monedaDestino + " es de: " + resultado + " " + monedaDestino);
                return resultado;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0.0;
    }





    @Override
    public String toString() {
        return  "COP: " + COP +
                ", ARS: " + ARS +
                ", BOB: " + BOB +
                ", BRL: " + BRL +
                ", USD: " + USD +
                ", CLP: " + CLP;
    }
}
