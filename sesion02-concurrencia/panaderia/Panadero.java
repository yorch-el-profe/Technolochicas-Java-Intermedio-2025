package panaderia;

import java.util.concurrent.Callable;

public class Panadero implements Callable<Void> {

    @Override
    public Void call() {

        try {
            // Cada panadero va a calcular cuántos panes puede hacer
            int cantidad = (int) (Math.random() * 50000) + 1; // 1 - 5

            System.out.println("👩‍🍳 puede hacer " + cantidad + " panes");

            for (int i = 1; i <= cantidad; i++) {
                // Calculando un índice aleatorio del arreglo "catalogo" (0 - tamaño del
                // arreglo)
                int indice = (int) (Math.random() * Panaderia.catalogo.length);

                String pan = Panaderia.catalogo[indice]; // Cocinando un pan

                // Duerme X milisegundos al hilo de ejecución
                Thread.sleep(0);
            
                // Bloqueamos la canasta
                Panaderia.candado.lock();

                try {
                    // Depositamos el pan en la canasta de la panaderia
                    // Zona de rieso ⚠️
                    Panaderia.canasta.add(pan);
                } finally {
                    Panaderia.candado.unlock();
                }
            }
        } catch (InterruptedException ex) {}

        return null;
    }
}
