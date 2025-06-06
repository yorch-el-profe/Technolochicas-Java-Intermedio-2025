package org.bedu.reactivo;

import java.util.Arrays;
import java.util.List;

public class Pizzeria {
    public static List<String> ingredientes = Arrays.asList("🍍", "🍄", "🧅", "🍗", "🥩", "🧀", "🫑", "🫒");
    
    public static void iniciar() {
        Mostrador.tomarPedidos()
            .subscribe(pizza -> {
                System.out.println(pizza);
            });
    }
}
