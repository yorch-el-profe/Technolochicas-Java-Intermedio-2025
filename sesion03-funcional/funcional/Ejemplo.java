package funcional;

import java.util.Arrays;
import java.util.List;

public class Ejemplo {

    public static void main(String[] args) {

        // Creando una lista de números
        List<Integer> numeritos = Arrays.asList(9, 11, 8, 100, 3, 4);

        // Imperativa
        // Decir lo que quiero y cómo lo quiero obtener
    
        for (int i = 0; i < numeritos.size(); i++) {
            System.out.println("Imperativo: " + numeritos.get(i));
        }

        // Declarativa
        // Lenguajes funcionales: Haskell, Elixir, (medio funcionales) Javascript, Python, Java
        // Decir lo que quieron sin preocuparme del cómo

        numeritos
            .forEach(numero -> System.out.println("Declarativo: " + numero));

        // Función: Es una caja negra que dada una entrada, regresa una salida
        // Lambda: Una función anónima que recibe paramétros y hace algo
    }
}