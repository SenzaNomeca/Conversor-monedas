package ConversorMoneda.Principal;

import ConversorMoneda.Logica.ConsultaMoneda;
import ConversorMoneda.Logica.Moneda;
import ConversorMoneda.Logica.RegistroConversion;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String monedaOrigen;
        String monedaDestino;
        double resultado;

        ArrayList<RegistroConversion> listaDeConversiones = new ArrayList<>();
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();

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
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 3:
                    monedaOrigen = "COP";
                    monedaDestino = "MXN";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));

                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 4:
                    monedaOrigen = "MXN";
                    monedaDestino = "COP";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 5:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 6:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 7:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) { // Solo guarda si la conversión fue exitosa
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 8:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    resultado = Moneda.convertirMoneda(monedaOrigen, monedaDestino, teclado, consultaMoneda);

                    if (resultado != 0.0) {
                        listaDeConversiones.add(new RegistroConversion(monedaOrigen, monedaDestino, resultado));
                    }
                    esperarRespuestaUsuario(teclado);
                    break;

                case 9:
                    System.out.println("Gracias por usar, adios :D");
                    break;

                default:
                    System.out.println("Opcion inválida");
            }

        }while(opcion != 9);

        System.out.println("Registro de conversiones: ");
        if(listaDeConversiones.isEmpty()){
            System.out.println("No se han realizados conversiones aun");
        }else {
            int i = 1;
            for(RegistroConversion conversion : listaDeConversiones){
                System.out.println("Conversion numero: " + i);
                System.out.println(conversion);
                i++;
            }
        }

    }

    public static void esperarRespuestaUsuario(Scanner teclado){
        System.out.println("Presiona Enter para continuar...");
        teclado.nextLine();
        teclado.nextLine();
    }
}
