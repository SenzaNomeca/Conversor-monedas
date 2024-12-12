package ConversorMoneda.Logica;

public class RegistroConversion {
    private String monedaOrigen;
    private double valorOrigen;
    private String monedaDestino;
    private double resultado;

    public RegistroConversion(String monedaOrigen, double valorOrigen,String monedaDestino, double resultado) {
        this.monedaOrigen = monedaOrigen;
        this.valorOrigen = valorOrigen;
        this.monedaDestino = monedaDestino;
        this.resultado = resultado;
    }

    public String toString() {
        return monedaOrigen + "("+ valorOrigen+")" + " --> " + monedaDestino + ": " + resultado;
    }
}
