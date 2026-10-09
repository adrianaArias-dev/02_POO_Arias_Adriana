package vallegrande.edu.pe.sistemaproducto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.sistemaproducto.controller.MainController;
import vallegrande.edu.pe.sistemaproducto.view.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainView view = new MainView();
        new MainController(view);

        Scene scene = new Scene(view, 800, 450);
        primaryStage.setTitle("Sistema de Gestión de Productos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}