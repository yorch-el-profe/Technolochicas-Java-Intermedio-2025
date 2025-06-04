package facturas;

import java.util.Scanner;

public class Main {
    
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n🤖 ¿Cuál es el código del ticket?");

            String codigo = sc.nextLine();

            System.out.println("\n🤖 ¿Cuál es el total del ticket?");

            double total = sc.nextDouble();
            sc.nextLine();

            System.out.println("\n⌛ Creando factura del ticket " + codigo);

            Sat.crearFactura(new Ticket(codigo, total))
                // Seguimos la caneda de ejecución
                .thenCompose(factura -> Sat.firmarFactura(factura))
                // Una vez terminado el proceso "secuencial", hacemos otra cosa
                .thenAccept(facturaFirmada -> System.out.println(facturaFirmada))
                .thenAccept(nada -> System.out.println("\n✅ Factura firmada por el SAT"));

            System.out.println("\n🤖 ¿Quieres seguir creando facturas? (Y/N)");

            String continuar = sc.nextLine();

            if (!continuar.toLowerCase().equals("y")) {
                break;
            }
        }

        sc.close();
        System.out.println("\nTerminando programa...");
    }
}
