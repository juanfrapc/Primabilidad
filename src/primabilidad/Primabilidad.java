package primabilidad;

import java.util.Scanner;
import static primabilidad.AlgoritmoProbabilistico.esPrimo;

public class Primabilidad {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String command = "";

        while (true) { // bucle infinito.
            //Menú
            System.out.println("1. Introducir número");
            System.out.println("2. Ejecutar pruebas");
            System.out.println("[Pulse la tecla 'Q' para salir]");
            System.out.print("Comando a ejecutar: ");
            // Menú

            command = userInput.nextLine();
            switch (command) {
                case "1": // a través de fichero
                    System.out.print("\nIntroduzca el número: ");
                    int numero = userInput.nextInt();
                    System.out.print("\nIntroduzca el número de pruebas: ");
                    int pruebas = userInput.nextInt();
                    if (numero <= 0) {
                        System.out.println("El número debe ser positivo");
                        break;
                    }
                    if (esPrimo(numero, pruebas)) {
                        System.out.println("El número puede ser primo");
                    } else {
                        System.out.println("El número no es primo");
                    }
                    break;
                case "2":
                    System.out.println("Comenzando las pruebas");
                    System.out.println("=========================");
                    long[] candidatos = {561, 997};//, 2040, 666665};
                    for (long candidato : candidatos) {
                        for (int i = 1; i <= 4; i++) {
                            System.out.println("Comprobando " +candidato +" para " + i + " pruebas");
                            comprueba(561, i, 100);
                        }
                    }
                    break;
                case "q":
                    return;
                case "Q":
                    return;
                default:
                    System.out.println("\nError: Comando erróneo\n");
            }

        }
    }

    public static void comprueba(int numero, int nPruebas, int nIteraciones) {
        double aciertos = 0;

        for (int i = 1; i <= nIteraciones; i++) {
            if (esPrimo(numero, nPruebas)) {
                System.out.println("lo es");
                aciertos++;
            }
        }
        System.out.println("Porcentaje de aciertos = " + aciertos / nIteraciones * 100 + "%");
        System.out.println("");

    }

}
