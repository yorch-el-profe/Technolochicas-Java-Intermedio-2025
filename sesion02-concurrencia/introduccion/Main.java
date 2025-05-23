package introduccion;

// En este caso, la clase "Main" funciona como el hilo principal

public class Main {
    
    public static void main(String[] args) {
        
        // Si heredamos de Thread
        MiPrimerHilo primerHilo = new MiPrimerHilo();

        // Si usamos Runnable
        MiSegundoHilo segundoHiloRunnable = new MiSegundoHilo();
        Thread segundoHilo = new Thread(segundoHiloRunnable);

        // Nota: Ejecutar .start() y no .run()
        primerHilo.start();
        segundoHilo.start();
    }
}

/*
 * run() -> Escribir código
 * start() -> Ejecutar
 */
