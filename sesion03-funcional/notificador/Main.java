package notificador;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    
    public static void main(String[] args) {
        
        List<Usuario> usuarios = Lector.leerArchivo();

        // Predicado: Función que regresa un booleano
        // En este caso, el predicado evalua la notificacion
        Predicate<Usuario> notificarPorEmail = (u) -> u.getNotificacion() == Notificacion.EMAIL;

        List<Usuario> viaEmail = usuarios
            .stream()
            .filter(notificarPorEmail)
            .collect(Collectors.toList());


        List<Usuario> viaTelefono = usuarios
            .stream()
            .filter((u) -> u.getNotificacion() == Notificacion.TELEFONO)
            .collect(Collectors.toList());

        Function<Usuario, String> imprimirEmail = (u) -> "📧 " + u.getNombre() + " notificado en " + u.getEmail().get();
        Function<Usuario, String> imprimirTelefono = (u) -> "📞 " + u.getNombre() + " notificado al " + u.getTelefono().get();

        viaEmail
            .stream()
            .map(imprimirEmail)
            .forEach(System.out::println);

        viaTelefono
            .stream()
            .map(imprimirTelefono)
            .forEach(System.out::println);
    }
}
