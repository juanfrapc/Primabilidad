package primabilidad;

import static primabilidad.AlgoritmoProbabilistico.esPrimo;

public class Primabilidad {

    public static void main(String[] args) {

        int nIteraciones = 100;
        int nPruebas = 1;
        int candidato = 561;
        double aciertos = 0;
        
        for (int i = 0; i < nIteraciones; i++) {
            if (esPrimo(candidato, nPruebas)){
                aciertos++;
            }
        }
        System.out.println("Porcentaje = " + aciertos/nIteraciones * 100 + "%");
    }
    
}
