package controller;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private TextField txtLongitud;

    @FXML
    private CheckBox chkMayusculas;

    @FXML
    private CheckBox chkNumeros;

    @FXML
    private CheckBox chkSimbolos;

    @FXML
    private Label lblContrasena;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        lblContrasena.setText("");
        lblMensaje.setText("Esperando configuracion...");

    }

    @FXML
    private void Generar() {

        if (txtLongitud.getText().trim().isEmpty()) {

            lblMensaje.setText("Ingrese la longitud de la contraseña.");
            lblContrasena.setText("");
            return;

        }

        int longitud;

        try {

            longitud = Integer.parseInt(txtLongitud.getText());

        } catch (NumberFormatException e) {

            lblMensaje.setText("La longitud debe ser numerica.");
            lblContrasena.setText("");
            return;

        }

        if (longitud < 6) {

            lblMensaje.setText("La longitud debe ser mayor o igual a 6.");
            lblContrasena.setText("");
            return;

        }

        String caracteres = "abcdefghijklmnopqrstuvwxyz";

        if (chkMayusculas.isSelected()) {

            caracteres += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        }

        if (chkNumeros.isSelected()) {

            caracteres += "0123456789";

        }

        if (chkSimbolos.isSelected()) {

            caracteres += "!@#$%&*?";

        }

        Random random = new Random();

        StringBuilder contraseña = new StringBuilder();

        for (int i = 0; i < longitud; i++) {

            int indice = random.nextInt(caracteres.length());

            contraseña.append(caracteres.charAt(indice));

        }

        lblContrasena.setText(contraseña.toString());

        lblMensaje.setText("Contraseña generada correctamente.");

    }

    @FXML
    private void Limpiar() {

        txtLongitud.clear();

        chkMayusculas.setSelected(false);

        chkNumeros.setSelected(false);

        chkSimbolos.setSelected(false);

        lblContrasena.setText("");

        lblMensaje.setText("Esperando configuracion...");

        txtLongitud.requestFocus();

    }

    @FXML
    private void MouseEntrar(MouseEvent event) {

        lblMensaje.setText("Presione para generar una nueva contraseña.");

    }

    @FXML
    private void MouseSalir(MouseEvent event) {

        lblMensaje.setText("Esperando configuracion...");

    }

    @FXML
    private void EnterPresionado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            Generar();

        }

    }

}