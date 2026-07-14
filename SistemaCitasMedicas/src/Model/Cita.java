package Model;

import java.time.LocalDate;

public class Cita{
    private String codigo;
    private String nombre;
    private long cedula;
    private long telefono;
    private String medico;
    private String especialidad;
    private LocalDate fecha;
    private int hora;
    private String motivoConsulta;
    private String estado;

    

    public Cita(String codigo, String nombre, long cedula, long telefono, String medico, String especialidad, LocalDate fecha, int hora, String motivoConsulta, String estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public long getCedula(){
        return cedula;
    }
    public long getTelefono(){
        return telefono;
    }
    public String getMedico(){
        return medico;
    }
    public String getEspecialidad(){
        return especialidad;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public int getHora(){
        return hora;
    }
    public String getMotivoConsulta(){
        return motivoConsulta;
    }
    public String getEstado(){
        return estado;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCedula(long cedula){
        this.cedula = cedula;
    }
    public void setTelefono(long telefono){
        this.telefono = telefono;
    }
    public void setMedico(String medico){
        this.medico = medico;
    }
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    public void setHora(int hora){
        this.hora = hora;
    }
    public void setMotivoConsulta(String motivoConsulta){
        this.motivoConsulta = motivoConsulta;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }

}