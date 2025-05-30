import java.util.concurrent.CompletableFuture;

public class FuturoNoBloqueante {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Resultado";
        });

        future.thenAccept(result -> System.out.println("Resultado: " + result));

        future.exceptionally(ex -> {
            System.out.println("Error: " + ex.getMessage());
            return null;
        });

        System.out.println("Termino el hilo principal");

    }
}
