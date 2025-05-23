package executor;

import java.util.concurrent.Callable;

/**
 * Callable permite "regresar" un valor (o no) al hilo principal
 * 
 * El tipo genérico es el tipo de lo que voy a regresar.
 * 
 *  Por ejemplo:
 *    Si regreso un numero, entonces sería Callable<Integer>
 *    Si regreso un objeto de tipo Persona entonces sería Callable<Persona>
 *    Si NO regreso nada entonces sería Callable<Void>
 *     Nota: Void es el wrapper class, void es el tipo primitivo
 *     Nota 2: void = nada
 */

public class MiTercerHilo implements Callable<Void> {

    // Con Callable<T> se sobreescribe el método "call"
    // El tipo de retorno es el mismo que el genérico
    @Override 
    public Void call() {

        for (int i = 0; i < 10; i++) {
            System.out.println("=> " + i);
        }

        // Como este ejemplo usa "Void" se regresa "null"
        return null; // El return es obligatorio
    }
}
