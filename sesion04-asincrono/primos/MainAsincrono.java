package primos;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class MainAsincrono {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n🤖 ¿Cuántos números primos quieres calcular?");

            int cantidad = sc.nextInt();
            sc.nextLine();

            // Para crear un proceso asíncrono se pueden utilizar cualquiera de los 2 métodos:
            // supplyAsync: Se usa cuando el proceso regresa un valor
            // runAsync: Se usa cuando el proceso NO regresa un valor

            // Vamos el proceso asíncrono en varios pasos (cadena de ejecución)
            CompletableFuture
                // Paso 1. Calcular los N primos
                .supplyAsync(() -> {
                    System.out.println("\n⌛ Calculando " + cantidad + " primos...");
                    return CalculadoraPrimos.calcularPrimerosPrimos(cantidad);
                })
                // Paso 2. Escribir en un archivo
                // .thenApply: El paso actual regresa un valor
                // .thenAccept: El paso actual no regresa un valor
                // .thenCombine: El paso actual regresa un FUTURO
                .thenAccept((primos) -> ManejoArchivos.escribir(primos))
                .thenAccept((x) ->  System.out.println("\n✅ Cálculo de " + cantidad + " primos terminado"))
                // Si hubiera un error en CUALQUIERA DE LOS PASOS ANTERIORES se ejecuta "exceptionally"
                .exceptionally((err) -> {
                    System.out.println("\n❌ Ocurrió un error inesperado");
                    return null;
                });
            // -------------------------------------------------------------------------
            System.out.println("\n🤖 ¿Quieres seguir calculando? (Y/N)");

            String continuar = sc.nextLine();

            if (!continuar.toLowerCase().equals("y")) {
                break;
            }
        }

        sc.close();
        System.out.println("\nTerminando programa...");
    }
}
