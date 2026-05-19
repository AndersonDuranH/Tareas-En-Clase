import java.util.ArrayList;
import java.util.Scanner;

class Menu {

    public static void main(String[] args) {

        int opcion;

        Scanner sc = new Scanner(System.in);

        ArrayList<Paciente> pacientes = new ArrayList<>();

        do {

            Paciente paciente = new Paciente("", 0, "", "");

            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Mostrar informacion de pacientes");
            System.out.println("3. Calcular IMC");
            System.out.println("4. Agregar resultado de IMC para saber si Tiene: Bajo peso, Peso normal, Sobrepeso");
            System.out.println("5. Mostrar todos los pacientes registrados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Digite el nombre del paciente: ");
                    String nombre = sc.nextLine();

                    System.out.print("Digite la edad del paciente: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite el genero del paciente: ");
                    String genero = sc.nextLine();

                    System.out.print("Digite los sintomas del paciente: ");
                    String sintomas = sc.nextLine();

                    pacientes.add(
                        new Paciente(nombre, edad, genero, sintomas)
                    );

                    System.out.println("Paciente registrado.");
                    break;

                case 2:

                    if (pacientes.isEmpty()) {

                        System.out.println("No hay pacientes registrados.");

                    } else {

                        for (Paciente p : pacientes) {

                            System.out.println("----------------------");
                            Paciente.Imprimir(p);
                        }
                    }

                    break;

                case 3:

                    Paciente.CalcularIMC(sc);
                    break;

                case 4:

                    paciente.DeterminarPesoPaciente(sc);
                    break;

                case 5:

                    System.out.println("\nLista de pacientes:");
                    Paciente.MostrarPacientes(pacientes);

                    break;

                case 6:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}