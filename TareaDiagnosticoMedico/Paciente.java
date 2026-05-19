import java.util.ArrayList;
import java.util.Scanner;

class Paciente {

    private String nombre;
    private int edad;
    private String genero;
    private String sintomas;

    public Paciente(String nombre, int edad, String genero, String sintomas) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.sintomas = sintomas;
    }


    public String getNombre() {
        return nombre;
    }

    public static void Imprimir(Paciente paciente) {

        System.out.println("Informacion del paciente:");
        System.out.println("Nombre: " + paciente.nombre);
        System.out.println("Edad: " + paciente.edad);
        System.out.println("Genero: " + paciente.genero);
        System.out.println("Sintomas: " + paciente.sintomas);
    }


    public static void CalcularIMC(Scanner sc) {

        System.out.print("Ingrese el peso del paciente en kg: ");
        double peso = sc.nextDouble();

        System.out.print("Ingrese la altura del paciente en metros: ");
        double altura = sc.nextDouble();

        double imc = peso / (altura * altura);

        System.out.printf("El IMC del paciente es: %.2f\n", imc);
    }


    public void DeterminarPesoPaciente(Scanner sc) {

        System.out.print("Ingrese su IMC: ");
        double imc = sc.nextDouble();

        if (imc < 18.5) {

            System.out.println("El paciente esta bajo peso.");

        } else if (imc >= 18.5 && imc < 25) {

            System.out.println("El paciente tiene un peso normal.");

        } else if (imc >= 25 && imc < 30) {

            System.out.println("El paciente tiene sobrepeso.");

        } else {

            System.out.println("El paciente tiene obesidad.");
        }
    }


    public static void MostrarPacientes(ArrayList<Paciente> pacientes) {

        if (pacientes.isEmpty()) {

            System.out.println("No hay pacientes registrados.");
            return;
        }

        for (int i = 0; i < pacientes.size(); i++) {

            System.out.println(
                "Paciente " + (i + 1) + ": "
                + pacientes.get(i).getNombre()
            );
        }
    }
}
    

