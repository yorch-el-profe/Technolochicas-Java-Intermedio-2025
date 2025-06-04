package primos;

import java.util.List;
import java.util.Scanner;

public class MainSincrono {
    
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n🤖 ¿Cuántos números primos quieres calcular?");

            int cantidad = sc.nextInt();
            sc.nextLine();

            System.out.println("\n⌛ Calculando " + cantidad + " primos...");

            try {
                // Paso 1. Calculamos los primeros n primos
                List<Long> primos = CalculadoraPrimos.calcularPrimerosPrimos(cantidad);

                // Paso 2. Escribir archivo
                ManejoArchivos.escribir(primos);
            } catch (Exception ex) {
                System.out.println("\n❌ Ocurrió un error inesperado");
            }

            System.out.println("\n✅ Cálculo de " + cantidad + " primos terminado");

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
