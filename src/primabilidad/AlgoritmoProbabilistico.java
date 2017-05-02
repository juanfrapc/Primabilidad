package primabilidad;

import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.round;
import java.util.HashSet;
import java.util.Set;

public class AlgoritmoProbabilistico {

    public static boolean esPrimo(int numero, int pruebas) {

        if (numero%2==0) {
            return false;
        }
        
        Set<Integer> testigos = seleccionarTestigosAleatorios(numero, pruebas);
        Set<Integer> comprobadores = generarComprobadores(numero);
        for (Integer testigo : testigos) {
            long n = modPower(testigo, numero - 1, numero);
            if (n != 1) {
                System.out.println("NO cumple p1: " + testigo + "  " + n);
                return false;
            }
            //(pow(testigo, comprobador) - 1)
            for (Integer comprobador : comprobadores) {
                long pot = modPower(testigo, comprobador, numero);
                pot = pot == 0 ? numero-1:pot-1;
                long mcd = MCD(numero,pot);
                if (mcd > 1 && mcd < numero) {
                    System.out.println("NO cumple p2: " + testigo + "  " + comprobador + "  " + mcd);
                    return false;
                }
            }
            System.out.println("Lo cumple para testigo = " + testigo);
        }
        return true;
    }

    private static Set<Integer> seleccionarTestigosAleatorios(int numero, int pruebas) {
        HashSet<Integer> testigos = new HashSet();
        while (testigos.size() < pruebas) {
            testigos.add((round((float) ((numero - 1) * random() + 0.5))));
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

    private static long MCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long modPower(int base, int exponente, int modulo) {
        int lim = (int) Math.ceil(log(exponente) / log(2));
        long[] vector = new long[lim+1]; // v[i]=base^i mod modulo;
        vector[0] = 1;
        vector[1]=base;
        for (int i = 2; i < lim+1; i++) {
            vector[i] = vector[i - 1] * vector[i-1];
            vector[i] %= modulo;
        }
        long res = 1;
        for (int i = lim - 1; i >= 0; i--) {
            int umbral = (int) pow(2, i);
            if (exponente >= umbral) {
                res = ((res * vector[i+1]) % modulo);
                exponente = exponente - umbral;
            }
        }
        return res;
    }

}
