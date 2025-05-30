package notificador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Lector {

    public static List<Usuario> leerArchivo() {
        List<Usuario> usuarios = new LinkedList<>();

        try {
            File archivo = new File("./notificador/cobranza.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(lector);

            String linea;

            while((linea = buffer.readLine()) != null) {
                String[] entradas = linea.split("\\|");

                String nombreArchivo = entradas[0];
                String emailArchivo = entradas[1];
                String telefonoArchivo = entradas[2];
                String notificacionArchivo = entradas[3];

                Optional<String> email = emailArchivo.isEmpty() ? Optional.empty() : Optional.of(emailArchivo);
                Optional<String> telefono = telefonoArchivo.isEmpty() ? Optional.empty() : Optional.of(telefonoArchivo);
                Notificacion notificacion = notificacionArchivo.equals("EMAIL") ? Notificacion.EMAIL : Notificacion.TELEFONO;

                usuarios.add(new Usuario(nombreArchivo, email, telefono, notificacion));
            }

            buffer.close();

            return usuarios;
        } catch (IOException ex) {
            ex.printStackTrace();
            return new LinkedList<>();
        }
    }
}