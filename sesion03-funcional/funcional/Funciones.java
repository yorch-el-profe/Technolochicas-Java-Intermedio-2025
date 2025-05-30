package funcional;

import java.util.Arrays;
import java.util.List;

public class Funciones {
    
    public static void main(String [] args) {

        List<Integer> numeritos = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Stream API
        // Me permite poder utilizar programación funcional sobre las listas

        // Objetivo: Tomar cada número y multiplicarlo por 10

        // Imperativa
        for (int i = 0; i < numeritos.size(); i++) {
            int miNumero = numeritos.get(i); // Obteniendo el i-esimo numero
            int nuevoNumero = miNumero * 10;
            numeritos.set(i, nuevoNumero);
        }

        for (int i = 0; i < numeritos.size(); i++) {
            System.out.println(numeritos.get(i));
        }

    }
}
