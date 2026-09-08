package vallegrande.edu.veterinaria;

import javafx.fxml.FXML;

public class HelloController {

    @FXML
    protected void onIniciarSesionClick() {
        System.out.println("Redirigiendo a Iniciar Sesión...");
    }

    @FXML
    protected void onSoporteClick() {
        System.out.println("Abriendo modulo de Soporte Técnico...");
    }
}