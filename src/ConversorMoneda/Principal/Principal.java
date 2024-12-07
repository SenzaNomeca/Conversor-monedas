package ConversorMoneda.Principal;

import ConversorMoneda.Logica.ConsultaMoneda;
import ConversorMoneda.Logica.ConvertirMoneda;
import ConversorMoneda.Logica.Moneda;

import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String monedaOrigen;
        String monedaDestino;

        int opcion;

        do{
            System.out.println("**************************************************************");
            System.out.println("[=  Bienvenido/a al Conversor de Moneda  =] \n");
            System.out.println("1) Dolar --> Peso argetino");
            System.out.println("2) Peso argentino --> Dolar");
            System.out.println("3) Peso colombiano --> Peso mexicano");
            System.out.println("4) Peso mexicano --> Peso colombiano");
            System.out.println("5) Peso colombiano --> Dolar");
            System.out.println("6) Dolar --> Peso colombiano");
            System.out.println("7) Real brasilenho --> Dolar");
            System.out.println("8) Dolar --> Rea; brasilenho ");
            System.out.println("9) Salir");
            System.out.println("**************************************************************");

            System.out.println("Elija una opcion valida: \n");
            opcion = teclado.nextInt();


            switch (opcion){
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";

                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());
                    break;

                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());
                    break;

                case 3:
                    monedaOrigen = "COP";
                    monedaDestino = "MXN";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());
                    break;

                case 4:
                    monedaOrigen = "MXN";
                    monedaDestino = "COP";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());

                    break;

                case 5:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());
                    break;

                case 6:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());

                    break;

                case 7:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());
                    break;

                case 8:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, new ConsultaMoneda());
                    break;

                case 9:
                    System.out.println("Gracias por usar, adios :D");
                    break;

                default:
                    System.out.println("Opcion inválida");
            }

        }while(opcion != 9);

    }
}
