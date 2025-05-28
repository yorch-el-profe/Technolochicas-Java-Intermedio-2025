package panaderia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    
    public static void main(String[] args) {
        
        // 1. Creamos el "pool" de hilos
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 2. Agregamos los hilos al "pool"
        executor.submit(new Panadero());
        executor.submit(new Panadero());
        executor.submit(new Panadero());

        // 3. Ya no agregamos más
        executor.shutdown();

        // 4. Esperamos a que todos los panaderos terminen
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {}

        // 5. Los panaderos ya terminaron
        System.out.println("Cantidad de panes horneados: " + Panaderia.canasta.size());
    }
}
