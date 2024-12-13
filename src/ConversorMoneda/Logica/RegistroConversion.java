package ConversorMoneda.Logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroConversion {
    private String monedaOrigen;
    private double valorOrigen;
    private String monedaDestino;
    private double resultado;
    LocalTime hora;

    public RegistroConversion(String monedaOrigen, double valorOrigen,String monedaDestino, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.valorOrigen = valorOrigen;
        this.monedaDestino = monedaDestino;
        this.resultado = resultado;
        this.hora =  LocalTime.now();
    }

    public String toString() {
        return monedaOrigen + "("+ valorOrigen+")" + " --> " + monedaDestino + ": " + resultado
                + "\n HORA: " + hora + "\n";
    }
}
