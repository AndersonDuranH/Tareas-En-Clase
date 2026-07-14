package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private TextField txtMonto;

    @FXML
    private ComboBox<String> cmbMoneda;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        lblResultado.setText("");
        lblMensaje.setText("Esperando informacion...");

    }

    @FXML
    private void CalcularConversion() {

        if (txtMonto.getText().trim().isEmpty()) {

            lblMensaje.setText("Ingrese un monto.");
            lblResultado.setText("");
            return;

        }

        if (cmbMoneda.getValue() == null) {

            lblMensaje.setText("Seleccione una moneda.");
            lblResultado.setText("");
            return;

        }

        double monto;

        try {

            monto = Double.parseDouble(txtMonto.getText());

        } catch (NumberFormatException e) {

            lblMensaje.setText("El monto debe ser numérico.");
            lblResultado.setText("");
            return;

        }

        double resultado;

        if (cmbMoneda.getValue().equals("Dolar Estadounidense")) {

            resultado = monto / 59.00;

            lblResultado.setText(String.format(
                    "RD$ %.2f equivale a %.2f USD",
                    monto,
                    resultado));

        } else {

            resultado = monto / 64.00;

            lblResultado.setText(String.format(
                    "RD$ %.2f equivale a %.2f EUR",
                    monto,
                    resultado));

        }

        lblMensaje.setText("Conversión realizada correctamente.");

    }

    @FXML
    private void Limpiar() {

        txtMonto.clear();

        cmbMoneda.getSelectionModel().clearSelection();

        lblResultado.setText("");

        lblMensaje.setText("Esperando informacion...");

        txtMonto.requestFocus();

    }

    @FXML
    private void MouseEntrar(MouseEvent event) {

        lblMensaje.setText("Presione para realizar la conversion.");

    }

    @FXML
    private void MouseSalir(MouseEvent event) {

        lblMensaje.setText("Esperando informacion...");

    }

    @FXML
    private void EnterPresionado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            CalcularConversion();

        }

    }

}