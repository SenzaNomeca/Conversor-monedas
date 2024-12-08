package ConversorMoneda.Logica;

public class RegistroConversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double resultado;

    public RegistroConversion(String monedaOrigen, String monedaDestino, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.resultado = resultado;


    }

    public String toString() {
        return monedaOrigen + " --> " + monedaDestino + ": " + resultado;
    }
}
