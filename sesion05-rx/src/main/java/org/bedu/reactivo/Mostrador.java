package org.bedu.reactivo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import io.reactivex.rxjava3.core.Observable;

public class Mostrador {

    public static Observable<Pizza> tomarPedidos() {
        Scanner sc = new Scanner(System.in);

        return Observable.create(emitter -> {
            while (true) {
                System.out.println("\n🤖 ¿Quieres ordenar una pizza 🍕?:");
                System.out.println("1. Sí");
                System.out.println("2. No");

                int opcion = sc.nextInt();
                sc.nextLine();

                if (opcion == 2) {
                    break;
                } else if (opcion != 1) {
                    System.out.println("\n❌ Opción inválida...");
                    continue;
                }

                List<String> ingredientesSeleccionados = new LinkedList<>();

                while (true) {
                    System.out.println("\n🤖 Selecciona " + (ingredientesSeleccionados.isEmpty() ? "algún" : "otro")
                            + " ingrediente (ingresa 0 para terminar):");

                    for (int i = 1; i <= Pizzeria.ingredientes.size(); i++) {
                        System.out.println(i + ". " + Pizzeria.ingredientes.get(i - 1));
                    }

                    int opcionIngrediente = sc.nextInt();
                    sc.nextLine();

                    if (opcionIngrediente < 0 || opcionIngrediente > Pizzeria.ingredientes.size()) {
                        System.out.println("\n❌ Opción inválida...");
                        continue;
                    } else if (opcionIngrediente == 0) {
                        break;
                    }

                    String ingrediente = Pizzeria.ingredientes.get(opcionIngrediente - 1);
                    ingredientesSeleccionados.add(ingrediente);
                }

                System.out.println(
                        "\n🤖 Preparando una pizza de " + ingredientesSeleccionados.size() + " ingredientes...");
                System.out.println(String.join(", ", ingredientesSeleccionados));

                // Ya tenemos los ingredientes de la pizza
                Pizza pizza = new Pizza(ingredientesSeleccionados);
                // Notificamos que hay un nuevo pedido
                emitter.onNext(pizza);
            }

            emitter.onComplete();
        });
    }
}
