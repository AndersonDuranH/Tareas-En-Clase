package Controller;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.*;

import java.time.LocalTime;

import Model.*;
import Utils.Archivo;
public class RegistrarCitaController {
    @FXML
    private TextField txtfCodigo;
    @FXML
    private TextField txtfNombre;
    @FXML
    private TextField txtfCedula;
    @FXML
    private TextField txtfTelefono;
    @FXML
    private ComboBox<String> cbMedicos;
    @FXML
    private ComboBox<String> cbEspecialidad;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private TextField txtfHora;
    @FXML
    private TextArea txtaMotivoConsulta;
    @FXML
    private ComboBox<String> cbEstado;
    @FXML
    private Button bttRegistrarConsulta;
    @FXML
    private TableView<Cita> tvLista;
    @FXML
    private TableColumn<Cita, String> columCodigo;
    @FXML
    private TableColumn<Cita, String> columPaciente;
    @FXML
    private TableColumn<Cita, String> columMedico;
    @FXML
    private TableColumn<Cita, String>columEspecialidad;
    @FXML
    private TableColumn<Cita, String> columFecha;
    @FXML
    private TableColumn<Cita, String> columHora;
    @FXML
    private TableColumn<Cita, String> columEstado;
    @FXML
    private Button bttCancelar;
    @FXML
    private Button bttGuardar;
    @FXML
    private Button bttLimpiar;
    @FXML
    private Button bttCargar;
    @FXML
    private Label lblEstado;
    @FXML
    private ObservableList<Cita> listaCitas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Especialidades();
        Medicos();
        Estados();
        ConfigurarTabla();
    }

    public void ConfigurarTabla(){
        columCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );

        columPaciente.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        columMedico.setCellValueFactory(
                new PropertyValueFactory<>("medico")
        );

        columEspecialidad.setCellValueFactory(
                new PropertyValueFactory<>("especialidad")
        );
        columFecha.setCellValueFactory(
                new PropertyValueFactory<>("fecha")
        );
        columHora.setCellValueFactory(
                new PropertyValueFactory<>("hora")
        );
        columEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado")
        );
        tvLista.setItems(listaCitas);
    }



    public void Especialidades(){
        cbEspecialidad.getItems().addAll(
            "Medicina General",
            "Pediatría",
            "Ginecología",
            "Cardiología",
            "Otorrinolaringología"
        );
    }
    public void Medicos(){
        cbMedicos.getItems().addAll(
            "Dr. Juan Pérez",
            "Dra. María Gómez",
            "Dr. Dionicio Hernandez",
            "Dra. Jeison Amparo", 
            "Dra. Franshelina Camilo"
        );
    }

    public void Estados(){
        cbEstado.getItems().addAll(
            "Programada",
            "Atendida",
            "Cancelada"
        );
    }

    public Cita CrearCita(){
        String especialidad = cbEspecialidad.getValue();
        String medico = cbMedicos.getValue();
        String estado = cbEstado.getValue();
        try{
            return new Cita(
                txtfCodigo.getText(),
                txtfNombre.getText(),
                Long.parseLong(txtfCedula.getText()),
                Long.parseLong(txtfTelefono.getText()),
                medico,
                especialidad,
                dpFecha.getValue(),
                Integer.parseInt(txtfHora.getText()),
                txtaMotivoConsulta.getText(),
                estado
            );
        }catch(Exception e){
            System.out.println("Error al crear la cita: " + e.getMessage());
            return null;
        }
    }

    @FXML
    public void onRegistrar() {
        Cita cita = CrearCita();
        if (cita != null) {
            listaCitas.add(cita);
        }
    }

    @FXML
    public void onLimpiar() {
        txtfCodigo.clear();
        txtfNombre.clear();
        txtfCedula.clear();
        txtfTelefono.clear();
        txtfHora.clear();
        txtaMotivoConsulta.clear();
        cbEspecialidad.setValue(null);
        cbMedicos.setValue(null);
        cbEstado.setValue(null);
        dpFecha.setValue(null);
        lblEstado.setText("Se Limpio Correctamente");
    }

    @FXML
    public void onCancelar() {
        Cita citaSeleccionada = tvLista.getSelectionModel().getSelectedItem();
        
        if (citaSeleccionada == null) {
            lblEstado.setText("Selecciona una cita para cancelar");
            return;
        }
        
        
        citaSeleccionada.setEstado("Cancelada");
        
        tvLista.refresh();
        
        lblEstado.setText("Cita cancelada: " + citaSeleccionada.getCodigo());
    }

    @FXML
    public void onGuardar() {
        if (listaCitas.isEmpty()) {
            lblEstado.setText("No hay citas para guardar");
            return;
        }
        for (Cita cita : listaCitas) {
            Archivo.GuardarCita(cita);
        }
        lblEstado.setText("Citas guardadas correctamente");
    }

    @FXML
    public void onCargar() {
        listaCitas.clear();
        listaCitas.addAll(Archivo.LeerCitas());
        lblEstado.setText("Citas cargadas correctamente");
    }
    
    
}
