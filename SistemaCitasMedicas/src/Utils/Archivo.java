package Utils;
import Model.Cita;
import java.io.*;
import java.time.*;
import java.util.ArrayList;
public class Archivo {

    public static void GuardarCita(Cita cita){
        try{
            FileWriter archivo = new FileWriter("Citas.txt", true);
            archivo.write(
                cita.getCodigo() +"|"+
                cita.getCedula() + "|" +
                cita.getEspecialidad() + "|" + 
                cita.getEstado() + "|" +
                cita.getFecha() + "|" +
                cita.getHora() + "|" +
                cita.getMedico() + "|" +
                cita.getMotivoConsulta() +  "|" +
                cita.getNombre() + "|" +
                cita.getTelefono() + "\n"
            );
            archivo.close();
            System.out.println("Cita guardada correctamente");
        }catch(Exception e){
            System.out.println("Error al guardar la cita: " + e.getMessage());
        }
    }

    public static ArrayList<Cita> LeerCitas(){
        ArrayList<Cita> citas = new ArrayList<>();
        try{
            FileReader archivo = new FileReader("Citas.txt");
            BufferedReader lector = new BufferedReader(archivo);
            String linea;
            while((linea = lector.readLine()) != null){
                String[] datos = linea.split("\\|");
                String codigo = datos[0];
                long cedula = Long.parseLong(datos[1]);
                String especialidad = datos[2];
                String estado = datos[3];
                LocalDate fecha = LocalDate.parse(datos[4]);
                int hora = Integer.parseInt(datos[5]);
                String medico = datos[6];
                String motivoConsulta = datos[7];
                String nombre = datos[8];
                long telefono = Long.parseLong(datos[9]);

                Cita cita = new Cita(codigo, nombre, cedula, telefono, medico, especialidad, fecha, hora, motivoConsulta, estado);
                citas.add(cita);
                System.out.println("Cita leída: " + cita.getCodigo() + ", " + cita.getNombre());
            }
            lector.close();
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado, se creará al guardar");
        }catch(Exception e){
            System.out.println("Error al leer las citas: " + e.getMessage());
        }
        return citas;
    }
}
