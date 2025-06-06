package org.bedu.reactivo;

import java.util.List;
import java.util.Random;

public class Pizza {

    private int orden;
    private List<String> ingredientes;
    private boolean terminada;

    public Pizza(int orden, List<String> ingredientes) {
        this.orden = orden;
        this.ingredientes = ingredientes;
    }

    public Pizza(List<String> ingredientes) {
        this.orden = new Random().nextInt(900);
        this.ingredientes = ingredientes;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    public int getOrden() {
        return orden;
    }

    @Override
    public String toString() {
        return "Orden #" + orden + ": " + String.join(",", ingredientes) + "..." + (terminada ? "✅ ¡LISTA!" : "⌛EN PREPARACION") ;
    }
}
