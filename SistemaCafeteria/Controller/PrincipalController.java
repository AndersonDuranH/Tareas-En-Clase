package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PrincipalController {

    @FXML
    private TextField txtCliente;

    @FXML
    private ComboBox<String> cmbBebida;

    @FXML
    private TextField txtCantidad;

    @FXML
    private CheckBox chkPostre;

    @FXML
    private Label lblResumen;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        lblResumen.setText("");
        lblMensaje.setText("Esperando datos de la compra...");

    }

    @FXML
    private void Calcular() {

        if (txtCliente.getText().trim().isEmpty()) {

            lblMensaje.setText("Ingrese el nombre del cliente.");
            lblResumen.setText("");
            return;

        }

        if (cmbBebida.getValue() == null) {

            lblMensaje.setText("Seleccione una bebida.");
            lblResumen.setText("");
            return;

        }

        if (txtCantidad.getText().trim().isEmpty()) {

            lblMensaje.setText("Ingrese la cantidad.");
            lblResumen.setText("");
            return;

        }

        int cantidad;

        try {

            cantidad = Integer.parseInt(txtCantidad.getText());

        } catch (NumberFormatException e) {

            lblMensaje.setText("La cantidad debe ser numérica.");
            lblResumen.setText("");
            return;

        }

        if (cantidad <= 0) {

            lblMensaje.setText("La cantidad debe ser mayor que cero.");
            lblResumen.setText("");
            return;

        }

        double precio = 0;

        switch (cmbBebida.getValue()) {

            case "Café americano":
                precio = 100;
                break;

            case "Cappuccino":
                precio = 150;
                break;

            case "Chocolate caliente":
                precio = 130;
                break;

            case "Jugo natural":
                precio = 120;
                break;

        }

        double subtotal = precio * cantidad;

        double total = subtotal;

        String postre = "No";

        if (chkPostre.isSelected()) {

            total += 75;
            postre = "Sí";

        }

        lblResumen.setText(
                "Cliente: " + txtCliente.getText()
                + "\nProducto: " + cmbBebida.getValue()
                + "\nCantidad: " + cantidad
                + "\nSubtotal: RD$ " + String.format("%.2f", subtotal)
                + "\nPostre: " + postre
                + "\nTotal: RD$ " + String.format("%.2f", total));

        lblMensaje.setText("Compra calculada correctamente.");

    }

    @FXML
    private void Limpiar() {

        txtCliente.clear();

        txtCantidad.clear();

        cmbBebida.getSelectionModel().clearSelection();

        chkPostre.setSelected(false);

        lblResumen.setText("");

        lblMensaje.setText("Esperando datos de la compra...");

        txtCliente.requestFocus();

    }

    @FXML
    private void MouseEntrar(MouseEvent event) {

        lblMensaje.setText("Presione para calcular el total de la compra.");

    }

    @FXML
    private void MouseSalir(MouseEvent event) {

        lblMensaje.setText("Esperando datos de la compra...");

    }

    @FXML
    private void EnterPresionado(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {

            Calcular();

        }

    }

}