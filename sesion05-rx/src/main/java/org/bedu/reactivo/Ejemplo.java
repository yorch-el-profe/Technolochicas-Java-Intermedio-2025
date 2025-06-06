package org.bedu.reactivo;

import io.reactivex.rxjava3.core.Observable;

public class Ejemplo {
    
    public static void main(String[] args) {
        
        /*
         * En la programación reactiva hay dos elementos
         * 1. Observable
         *  Es aquello que proporciona un "flujo" de datos (indeterminado/infinito)
         * 
         * 2. Observador
         *  Es aquello que "reacciona" al flujo de datos
         */

        // Son un observable
        Observable.just("😱", "🍕", "👨‍🍳")
            // Observador
            .subscribe(emoji -> {
                System.out.println(emoji);
            });

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            // Solo voy aceptar números pares
            .filter(numero -> numero % 2 == 0)
            // Transformamos cada número x 10
            .map(numero -> numero * 10)
            .subscribe(numero -> {
                System.out.println(numero);
            });

            // Creando mi propio observable, con mi propio comportamiento
        Observable.create(emitter -> {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(2000);
                emitter.onNext("💧 #" + i);
            }

            // Termina el observable (Ya no emite más valores)
            emitter.onComplete();
        }).subscribe(gota -> {
            System.out.println(gota);
        });
    }
}
