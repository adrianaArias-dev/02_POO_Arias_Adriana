package vallegrande.edu.pe.perfiljuego.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblIntentos;

    @FXML
    private TextField txtNumero;

    @FXML
    private Button btnAdivinar;

    @FXML
    private Button btnReiniciar;

    private static final int MIN = 1;
    private static final int MAX = 100;
    private final Random random = new Random();

    private int numeroSecreto;
    private int intentos;

    @FXML
    public void initialize() {
        iniciarJuego();
    }

    private void iniciarJuego() {
        numeroSecreto = random.nextInt(MAX - MIN + 1) + MIN;
        intentos = 0;

        txtNumero.clear();
        txtNumero.setDisable(false);
        btnAdivinar.setDisable(false);

        lblResultado.setText("Adivina un número entre " + MIN + " y " + MAX);
        lblResultado.setStyle("-fx-text-fill: #4a5568; -fx-font-weight: bold;");

        actualizarIntentos();
        txtNumero.requestFocus();
    }

    @FXML
    protected void onAdivinarClick() {
        String texto = txtNumero.getText().trim();

        if (texto.isEmpty()) {
            mostrarAviso("Escribe un número primero");
            return;
        }

        int numero;
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            mostrarAviso("Ingresa un número válido");
            return;
        }

        if (numero < MIN || numero > MAX) {
            mostrarAviso("Debe estar entre " + MIN + " y " + MAX);
            return;
        }

        intentos++;
        actualizarIntentos();

        if (numero == numeroSecreto) {
            lblResultado.setText("¡Correcto! Era el " + numeroSecreto + " en " + intentos + " intento(s)");
            lblResultado.setStyle("-fx-text-fill: #38a169; -fx-font-weight: bold;");
            txtNumero.setDisable(true);
            btnAdivinar.setDisable(true);
        } else if (numero < numeroSecreto) {
            lblResultado.setText("Muy bajo. Intenta un número mayor ⬆");
            lblResultado.setStyle("-fx-text-fill: #3182ce; -fx-font-weight: bold;");
        } else {
            lblResultado.setText("Muy alto. Intenta un número menor ⬇");
            lblResultado.setStyle("-fx-text-fill: #e53e3e; -fx-font-weight: bold;");
        }

        txtNumero.clear();
        txtNumero.requestFocus();
    }

    @FXML
    protected void onReiniciarClick() {
        iniciarJuego();
    }

    private void mostrarAviso(String mensaje) {
        lblResultado.setText(mensaje);
        lblResultado.setStyle("-fx-text-fill: #d69e2e; -fx-font-weight: bold;");
    }

    private void actualizarIntentos() {
        lblIntentos.setText("Intentos: " + intentos);
    }
}