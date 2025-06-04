package facturas;

import java.util.concurrent.CompletableFuture;

public class Sat {
    
    public static CompletableFuture<Factura> crearFactura(Ticket ticket) {
        return CompletableFuture
            .supplyAsync(() -> {
                System.out.println("\n🤖 Creando factura...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {}

                return new Factura(ticket.getCodigo(), ticket.getTotal());
            });
    }

    public static CompletableFuture<FacturaFirmada> firmarFactura(Factura factura) {
        return CompletableFuture
            .supplyAsync(() -> {
                System.out.println("\n🤖 Firmando factura...");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {}

                return new FacturaFirmada(factura.getCodigo(), factura.getTotal(), "SELLO-SAT-DIGITAL");
            });
    }
}
