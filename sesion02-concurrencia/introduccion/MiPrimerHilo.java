package introduccion;

public class MiPrimerHilo extends Thread {

    // Lo que sea que esté en el método run()
    // se ejecutará de manera concurrente

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("=> " + i);
        }
    }
}