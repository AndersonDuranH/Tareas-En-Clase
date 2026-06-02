import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private int edad;
    private double indiceAcademico;

    public Estudiante(String nombre, int edad, double indiceAcademico) {
        this.nombre = nombre;
        this.edad = edad;
        this.indiceAcademico = indiceAcademico;
    }

   

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
}

    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    private Scanner scanner = new Scanner(System.in);

     public void ingresarDatos() throws Exception {

            System.out.print("Digite su Nombre: ");
            nombre = scanner.nextLine();

            System.out.print("Digite su Edad: ");
            edad = scanner.nextInt();

            System.out.print("Digite su Índice Académico: ");
            indiceAcademico = scanner.nextDouble();
            try {

            validarEstudiante(nombre,edad,indiceAcademico);

            System.out.println("Estudiante registrado correctamente.");

            }
            catch(Exception e) {

            System.out.println(e.getMessage());

            }
        finally {
            System.out.println("Proceso finalizado.");

        }

    }

    private void validarEstudiante(String nombre, int edad, double indiceAcademico) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío.");
        }
        if (edad <= 0) {
            throw new Exception("La edad debe ser un número positivo.");
        }
        if (indiceAcademico < 0.0 || indiceAcademico > 5.0) {
            throw new Exception("El índice académico debe estar entre 0.0 y 5.0.");
        }
        if (edad < 18) {
            throw new Exception("La edad debe ser mayor o igual a 18 años.");
        }
    }

    public void Imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Índice Académico: " + indiceAcademico);
    }


    public static void Menu() throws Exception {
        
        Estudiante estudiante = new Estudiante("", 0, 0.0);
        int opcion;

        do{
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Imprimir datos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    estudiante.ingresarDatos();
                    break;
                case 2:
                    estudiante.Imprimir();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 3);
        entrada.close();
    }
    
}


    

    