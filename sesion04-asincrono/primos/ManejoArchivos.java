package primos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ManejoArchivos {
    
    public static void escribir(List<Long> numeros) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedTimestamp = now.format(formatter);
        
        try {
            File archivo = new File("./primos/resultado_" + formattedTimestamp + ".txt");
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);

            buffer.write(numeros.toString());

            buffer.close();
        } catch (IOException ex) {}
    }
}
