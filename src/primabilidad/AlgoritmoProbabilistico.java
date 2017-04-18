package primabilidad;

import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.round;
import java.util.HashSet;
import java.util.Set;

public class AlgoritmoProbabilistico {

    public static boolean esPrimo(int numero, int pruebas) {

        Set<Integer> testigos = seleccionarTestigosAleatorios(numero, pruebas);

        for (Integer testigo : testigos) {
            if (pow(testigo, numero - 1) % numero != 1) {
                return false;
            }

            for (int j = 0; j < arr.length; j++) {
                Object object = arr[j];
                
            }
        }

    }

    private static Set<Integer> seleccionarTestigosAleatorios(int numero, int pruebas) {
        HashSet<Integer> testigos = new HashSet();
        while (testigos.size() < pruebas) {
            testigos.add((round((float) (numero * random() + 0.5))));
        }
        return testigos;
    }

}
