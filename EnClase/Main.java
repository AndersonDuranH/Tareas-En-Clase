import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Leer();
    }

    public static void Leer() {
        ArrayList<Visitante> visitantes = new ArrayList<Visitante>();

        Scanner sc = new Scanner(System.in);
        
        for(int i = 1; i <= 2; i++){
        System.out.print("Digite su Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Digite su Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite su Cedula: ");
        String cedula = sc.nextLine();

        Visitante v = new Visitante(nombre, edad, cedula);
        visitantes.add(v);
        }

        for(Visitante v : visitantes)
{
    System.out.println("==============================");
    System.out.println("Nombre: " + v.getNombre());
    System.out.println("Edad: " + v.getEdad());
    System.out.println("Cedula: " + v.getCedula());
    System.out.println("==============================");
}
        

        sc.close();
        
    }
}
