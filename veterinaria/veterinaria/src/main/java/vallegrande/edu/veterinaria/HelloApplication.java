package vallegrande.edu.veterinaria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- PANEL IZQUIERDO (Información / Bienvenida) ---
        Label logoLabel = new Label("🐾");
        logoLabel.getStyleClass().add("logo-text");

        Label titleLabel = new Label("VetCare Desktop");
        titleLabel.getStyleClass().add("app-title");

        Label subtitleLabel = new Label("Bienvenido al Sistema de Gestión Veterinaria Valle Grande.");
        subtitleLabel.getStyleClass().add("app-subtitle");

        Label descLabel = new Label("Gestiona citas, historiales médicos y pacientes de manera eficiente.");
        descLabel.getStyleClass().add("app-subtitle");

        VBox leftPanel = new VBox(15, logoLabel, titleLabel, subtitleLabel, descLabel);
        leftPanel.getStyleClass().add("welcome-panel");
        leftPanel.setAlignment(Pos.CENTER_LEFT);
        leftPanel.setPrefWidth(320);

        // --- PANEL DERECHO (Tarjeta de Ingreso / Acciones) ---
        Label cardTitle = new Label("Iniciar Sesión");
        cardTitle.getStyleClass().add("card-title");

        Label userLabel = new Label("Usuario / Correo");
        userLabel.getStyleClass().add("field-label");
        TextField txtUser = new TextField();
        txtUser.setPromptText("Usuario / Correo");
        txtUser.getStyleClass().add("custom-input");

        Label passLabel = new Label("Contraseña");
        passLabel.getStyleClass().add("field-label");
        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Contraseña");
        txtPass.getStyleClass().add("custom-input");

        Button btnLogin = new Button("Iniciar Sesión");
        btnLogin.getStyleClass().add("btn-primary");
        btnLogin.setMaxWidth(Double.MAX_VALUE);

        Button btnRegister = new Button("Registrar Nueva Mascota / Cliente");
        btnRegister.getStyleClass().add("btn-secondary");
        btnRegister.setMaxWidth(Double.MAX_VALUE);

        Button btnForgot = new Button("¿Olvidé mi contraseña?");
        btnForgot.getStyleClass().add("btn-link");

        VBox formBox = new VBox(8, userLabel, txtUser, passLabel, txtPass);
        VBox rightPanel = new VBox(16, cardTitle, formBox, btnLogin, btnRegister, btnForgot);
        rightPanel.getStyleClass().add("card-panel");
        rightPanel.setAlignment(Pos.CENTER);
        rightPanel.setPrefWidth(300);

        // --- LAYOUT PRINCIPAL (Horizontal) ---
        HBox mainContainer = new HBox(25, leftPanel, rightPanel);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setPadding(new Insets(30));

        // --- FOOTER ---
        Label footerLabel = new Label("© 2026 Valle Grande - vallegrande.edu.veterinaria | Sistema de Gestión");
        footerLabel.getStyleClass().add("footer-text");

        VBox rootLayout = new VBox(20, mainContainer, footerLabel);
        rootLayout.setAlignment(Pos.CENTER);

        // --- ESCENA Y CSS ---
        Scene scene = new Scene(rootLayout, 720, 480);

        // Cargar archivo CSS desde las resources
        try {
            String cssPath = Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm();
            scene.getStylesheets().add(cssPath);
        } catch (Exception e) {
            System.err.println("No se pudo cargar el archivo styles.css: " + e.getMessage());
        }

        primaryStage.setTitle("VetCare Desktop - Bienvenidos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}