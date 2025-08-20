package com.literalura.literalura;

import com.literalura.literalura.service.AutorService;
import com.literalura.literalura.service.LibroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final LibroService libroService;
	private final AutorService autorService;

	public LiteraluraApplication(LibroService libroService, AutorService autorService) {
		this.libroService = libroService;
		this.autorService = autorService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mostrarMenu();
	}

	private void mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n=== Bienvenido a LiterAlura ===");
			System.out.println("1. Buscar libro por título");
			System.out.println("2. Listar todos los libros");
			System.out.println("3. Listar libros por idioma");
			System.out.println("4. Listar autores");
			System.out.println("5. Listar autores vivos en un año específico");
			System.out.println("6. Mostrar estadísticas de libros por idioma");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");

			try {
				opcion = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Opción inválida, ingrese un número.");
				continue;
			}

			switch (opcion) {
				case 1:
					buscarLibroPorTitulo(scanner);
					break;
				case 2:
					listarTodosLosLibros();
					break;
				case 3:
					listarLibrosPorIdioma(scanner);
					break;
				case 4:
					listarAutores();
					break;
				case 5:
					listarAutoresVivos(scanner);
					break;
				case 6:
					mostrarEstadisticas();
					break;
				case 0:
					System.out.println("¡Gracias por usar LiterAlura!");
					break;
				default:
					System.out.println("Opción inválida.");
			}
		}
		scanner.close();
	}

	// Métodos que llaman a los servicios
	private void buscarLibroPorTitulo(Scanner scanner) { /* ver LibroService */ }
	private void listarTodosLosLibros() { /* ver LibroService */ }
	private void listarLibrosPorIdioma(Scanner scanner) { /* ver LibroService */ }
	private void listarAutores() { /* ver AutorService */ }
	private void listarAutoresVivos(Scanner scanner) { /* ver AutorService */ }
	private void mostrarEstadisticas() { /* ver LibroService */ }
}
