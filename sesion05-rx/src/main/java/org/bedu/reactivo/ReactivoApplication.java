package org.bedu.reactivo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactivoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Mostrador.tomarPedidos();
	}
}
