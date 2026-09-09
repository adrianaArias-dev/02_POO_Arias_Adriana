module vallegrande.edu.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;

    opens vallegrande.edu.veterinaria to javafx.fxml;
    exports vallegrande.edu.veterinaria;
}