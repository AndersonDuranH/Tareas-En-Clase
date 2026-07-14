import java.io.*;
import java.util.Scanner;

public class Main {

    public static void agregarEstudiante() {
        Scanner scanner = new Scanner(System.in);
        Estudiante estudiante = new Estudiante("", 0, "");

        try {
            FileWriter archivo = new FileWriter("estudiante.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);

            System.out.print("Digite el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            estudiante.setNombre(nombre);

            System.out.print("Digite la edad del estudiante: ");
            int edad = scanner.nextInt();
            estudiante.setEdad(edad);
            scanner.nextLine(); 

            System.out.print("Digite la matrícula del estudiante: ");
            String matricula = scanner.nextLine();
            estudiante.setMatricula(matricula);

            escribir.println(estudiante.getNombre() + " | " + estudiante.getEdad() + " | " + estudiante.getMatricula());

            escribir.close();
            archivo.close();

            System.out.println("Estudiante agregado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar el estudiante.");
        }
    }

    public static void mostrarEstudiantes() {
        try {
            FileReader archivo = new FileReader("estudiante.txt");
            BufferedReader leer = new BufferedReader(archivo);

            String linea;

            System.out.println("\nLISTA DE ESTUDIANTES");

            while ((linea = leer.readLine()) != null) {
                System.out.println(linea);
            }

            leer.close();
            archivo.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo.");
        }
    }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("||======================||");
            System.out.println("||======== MENU ========||");
            System.out.println("||1. Agregar Estudiantes||");
            System.out.println("||2. Mostrar Estudiantes||");
            System.out.println("||3. Salir              ||");
            System.out.println("||======================||");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;

                case 2:
                    mostrarEstudiantes();
                    break;

                case 3:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}