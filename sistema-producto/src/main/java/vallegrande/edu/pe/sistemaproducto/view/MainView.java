package vallegrande.edu.pe.sistemaproducto.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.sistemaproducto.model.Producto;

public class MainView extends BorderPane {

    private TextField txtId;
    private TextField txtNombre;
    private TextField txtCategoria;
    private TextField txtCantidad;
    private TextField txtPrecio;

    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;

    private TableView<Producto> tablaProductos;
    private TableColumn<Producto, Integer> colId;
    private TableColumn<Producto, String> colNombre;
    private TableColumn<Producto, String> colCategoria;
    private TableColumn<Producto, Integer> colCantidad;
    private TableColumn<Producto, Double> colPrecio;

    public MainView() {
        setPadding(new Insets(20));

        // Estilo general del contenedor principal (Fondo Oscuro Elegante)
        setStyle("-fx-background-color: #0f172a;");

        // --- ENCABEZADO SUPERIOR ---
        Label lblTitulo = new Label("📦 Sistema de Gestión de Productos");
        lblTitulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #f8fafc; -fx-font-family: 'Segoe UI', sans-serif;");

        HBox topBox = new HBox(lblTitulo);
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(0, 0, 20, 0));
        setTop(topBox);

        // --- FORMULARIO DE ENTRADA (Tarjeta Izquierda) ---
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(14);
        grid.setPadding(new Insets(20));
        grid.setStyle("-fx-background-color: #1e293b; -fx-background-radius: 12px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 4);");

        // Estilo común para Labels
        String labelStyle = "-fx-text-fill: #94a3b8; -fx-font-weight: bold; -fx-font-size: 13px;";

        Label lblId = new Label("ID:");
        lblId.setStyle(labelStyle);
        txtId = createStyledTextField("Autogenerado", true);

        Label lblNombre = new Label("Nombre:");
        lblNombre.setStyle(labelStyle);
        txtNombre = createStyledTextField("Ej. Laptop Dell", false);

        Label lblCategoria = new Label("Categoría:");
        lblCategoria.setStyle(labelStyle);
        txtCategoria = createStyledTextField("Ej. Tecnología", false);

        Label lblCantidad = new Label("Cantidad:");
        lblCantidad.setStyle(labelStyle);
        txtCantidad = createStyledTextField("Ej. 10", false);

        Label lblPrecio = new Label("Precio ($):");
        lblPrecio.setStyle(labelStyle);
        txtPrecio = createStyledTextField("Ej. 1250.00", false);

        grid.add(lblId, 0, 0);
        grid.add(txtId, 1, 0);
        grid.add(lblNombre, 0, 1);
        grid.add(txtNombre, 1, 1);
        grid.add(lblCategoria, 0, 2);
        grid.add(txtCategoria, 1, 2);
        grid.add(lblCantidad, 0, 3);
        grid.add(txtCantidad, 1, 3);
        grid.add(lblPrecio, 0, 4);
        grid.add(txtPrecio, 1, 4);

        // --- BOTONES CON EFECTO HOVER ---
        btnRegistrar = createStyledButton("Registrar", "#3b82f6", "#2563eb");
        btnActualizar = createStyledButton("Actualizar", "#0d9488", "#0f766e");
        btnEliminar = createStyledButton("Eliminar", "#ef4444", "#dc2626");

        HBox boxBotones = new HBox(10, btnRegistrar, btnActualizar, btnEliminar);
        boxBotones.setAlignment(Pos.CENTER);
        boxBotones.setPadding(new Insets(15, 0, 0, 0));

        VBox leftBox = new VBox(15, grid, boxBotones);
        leftBox.setPadding(new Insets(0, 20, 0, 0));
        setLeft(leftBox);

        // --- TABLA DE DATOS (Derecha) ---
        tablaProductos = new TableView<>();
        tablaProductos.setStyle(
                "-fx-background-color: #1e293b; " +
                        "-fx-background-radius: 12px; " +
                        "-fx-border-radius: 12px; " +
                        "-fx-padding: 5px;"
        );

        colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(60);

        colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombre.setPrefWidth(160);

        colCategoria = new TableColumn<>("Categoría");
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCategoria.setPrefWidth(130);

        colCantidad = new TableColumn<>("Cantidad");
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colCantidad.setPrefWidth(90);

        colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colPrecio.setPrefWidth(100);

        tablaProductos.getColumns().addAll(colId, colNombre, colCategoria, colCantidad, colPrecio);
        tablaProductos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        setCenter(tablaProductos);
    }

    // Helper para campos de texto estilizados
    private TextField createStyledTextField(String placeholder, boolean disabled) {
        TextField field = new TextField();
        field.setPromptText(placeholder);
        field.setDisable(disabled);
        field.setStyle(
                "-fx-background-color: #334155; " +
                        "-fx-text-fill: #f8fafc; " +
                        "-fx-prompt-text-fill: #64748b; " +
                        "-fx-background-radius: 6px; " +
                        "-fx-padding: 8px 12px; " +
                        "-fx-font-size: 13px;"
        );
        return field;
    }

    // Helper para botones personalizados con animaciones/estilo
    private Button createStyledButton(String text, String colorHex, String hoverHex) {
        Button btn = new Button(text);
        String baseStyle =
                "-fx-background-color: " + colorHex + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 6px; " +
                        "-fx-padding: 8px 16px; " +
                        "-fx-cursor: hand; " +
                        "-fx-font-size: 13px;";

        String hoverStyle =
                "-fx-background-color: " + hoverHex + "; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 6px; " +
                        "-fx-padding: 8px 16px; " +
                        "-fx-cursor: hand; " +
                        "-fx-font-size: 13px;";

        btn.setStyle(baseStyle);
        btn.setOnMouseEntered(e -> btn.setStyle(hoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(baseStyle));
        return btn;
    }

    // Getters para controles
    public TextField getTxtId() { return txtId; }
    public TextField getTxtNombre() { return txtNombre; }
    public TextField getTxtCategoria() { return txtCategoria; }
    public TextField getTxtCantidad() { return txtCantidad; }
    public TextField getTxtPrecio() { return txtPrecio; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }
    public TableView<Producto> getTablaProductos() { return tablaProductos; }
}