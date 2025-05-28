package sincronizado;

public class Contador {
    
    private int valor = 0;

    // Nota: synchronized solo funciona cuando lo compartido es un objeto
    public synchronized void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}
