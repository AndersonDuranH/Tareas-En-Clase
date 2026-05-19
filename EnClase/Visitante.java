public class Visitante 
{
private String cedula;
private String nombre;
private int edad;

public Visitante(){
    setEdad(0);
    setNombre("");
    setCedula("");
}

public Visitante(String nombre, int edad, String cedula){
    this.edad = edad;
    this.nombre = nombre;
    this.cedula = cedula;
}

public String getNombre(){
    return nombre;
}

public int getEdad(){
    return edad;
}

public String getCedula(){
    return cedula;
}

public void setNombre(String nombre){
    this.nombre = nombre;
}
public void setEdad(int edad){
    this.edad = edad;
}
public void setCedula(String cedula){
    this.cedula = cedula;
}

}