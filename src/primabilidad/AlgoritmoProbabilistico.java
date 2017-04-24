package primabilidad;

import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.round;
import java.util.HashSet;
import java.util.Set;

public class AlgoritmoProbabilistico {

    public static boolean esPrimo(int numero, int pruebas) {

        Set<Integer> testigos = seleccionarTestigosAleatorios(numero, pruebas);
        Set<Integer> comprobadores = generarComprobadores(numero);
        for (Integer testigo : testigos) {
            if (pow(testigo, numero - 1) % numero != 1) {
                return false;
            }
            for (Integer comprobador : comprobadores) {
                int mcd = MCD((int) (pow(testigo, comprobador) - 1), numero);
                if (mcd > 1 && mcd < numero) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Set<Integer> seleccionarTestigosAleatorios(int numero, int pruebas) {
        HashSet<Integer> testigos = new HashSet();
        while (testigos.size() < pruebas) {
            testigos.add((round((float) (numero * random() + 0.5))));
        }
        return testigos;
    }

    private static Set<Integer> generarComprobadores(int numero) {
        HashSet<Integer> comprobadores = new HashSet();
        double frontera = log(numero - 1) / log(2);
        int aux;
        for (int i = 0; i < frontera; i++) {
            aux = (int) pow(2, i);
            if ((numero - 1) % aux == 0) {
                comprobadores.add((numero - 1) / aux);
            }
        }
        return comprobadores;
    }

    private static int MCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
