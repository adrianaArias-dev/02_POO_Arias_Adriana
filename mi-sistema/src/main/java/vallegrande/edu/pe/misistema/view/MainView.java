package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnReportes;
    private Button btnConfiguracion;
    private Button btnCitas;

    // Paleta coquette
    private final String ROSA_FUERTE   = "#E893B3";
    private final String ROSA_SUAVE    = "#F7D6E0";
    private final String ROSA_PASTEL   = "#FDEDF3";
    private final String CREMA         = "#FFF8F3";
    private final String VERDE_SALVIA  = "#B7D3C0";
    private final String TEXTO_OSCURO  = "#6B3F51";

    public MainView(){
        setStyle("-fx-background-color: " + CREMA + ";");
        crearMenu();
        mostrarInicio();
    }

    private void crearMenu(){
        VBox menu = new VBox(16);
        menu.setPadding(new Insets(28, 22, 28, 22));
        menu.setPrefWidth(230);

        Label titulo = new Label("🎀 Mi Sistema");
        titulo.setStyle(
                "-fx-font-size: 21px;" +
                        "-fx-font-family: 'Georgia';" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        Label subtitulo = new Label("✧ panel de control ✧");
        subtitulo.setStyle(
                "-fx-font-size: 11px;" +
                        "-fx-text-fill: " + ROSA_PASTEL + ";" +
                        "-fx-font-style: italic;"
        );

        VBox encabezado = new VBox(2, titulo, subtitulo);
        encabezado.setPadding(new Insets(0, 0, 15, 0));

        btnInicio        = crearBoton("🏠  Inicio");
        btnUsuarios      = crearBoton("💌  Usuarios");
        btnProductos     = crearBoton("🎁  Productos");
        btnReportes      = crearBoton("📈  Reportes");
        btnConfiguracion = crearBoton("🩰  Configuración");
        btnCitas         = crearBoton("🌸  Citas");

        menu.getChildren().addAll(
                encabezado,
                btnInicio,
                btnUsuarios,
                btnProductos,
                separador(),
                btnReportes,
                btnConfiguracion,
                btnCitas
        );

        menu.setStyle(
                "-fx-background-color: linear-gradient(to bottom, " + ROSA_FUERTE + ", #D97CA0);" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 12, 0, 3, 0);"
        );
        setLeft(menu);
    }

    private Label separador(){
        Label linea = new Label("· · · · · · · · · · · ·");
        linea.setStyle("-fx-text-fill: " + ROSA_PASTEL + "; -fx-font-size: 11px;");
        linea.setAlignment(Pos.CENTER);
        linea.setMaxWidth(Double.MAX_VALUE);
        linea.setAlignment(Pos.CENTER);
        return linea;
    }

    private Button crearBoton(String texto){
        Button boton = new Button(texto);
        boton.setPrefWidth(185);
        boton.setPrefHeight(42);
        boton.setAlignment(Pos.CENTER_LEFT);
        String base =
                "-fx-background-color: " + ROSA_PASTEL + ";" +
                        "-fx-text-fill: " + TEXTO_OSCURO + ";" +
                        "-fx-font-size: 13.5px;" +
                        "-fx-font-family: 'Georgia';" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 0 0 0 14;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.10), 4, 0, 1, 1);";
        boton.setStyle(base);

        boton.setOnMouseEntered(e -> boton.setStyle(base.replace(ROSA_PASTEL, "white")));
        boton.setOnMouseExited(e -> boton.setStyle(base));

        return boton;
    }

    public void mostrarInicio(){
        VBox contenido = new VBox(12);
        contenido.setAlignment(Pos.CENTER);
        Label titulo = new Label("✿ Bienvenida ✿");
        titulo.setStyle(
                "-fx-font-size: 30px;" +
                        "-fx-font-family: 'Georgia';" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: " + TEXTO_OSCURO + ";"
        );
        Label texto = new Label("Panel principal de tu sistema, con mucho cariño 🩷");
        texto.setStyle("-fx-font-size: 14px; -fx-text-fill: #A9718B; -fx-font-style: italic;");
        contenido.getChildren().addAll(titulo, texto);
        setCenter(envolver(contenido));
    }

    public void mostrarUsuarios(){
        VBox contenido = seccionBase("USUARIOS", "Personitas que forman parte del sistema 🎀");
        HBox tarjetas = new HBox(16);
        tarjetas.setAlignment(Pos.CENTER_LEFT);
        tarjetas.getChildren().addAll(
                crearTarjeta("Carlos Perez", "Administrador"),
                crearTarjeta("Maria Lopez", "Vendedora"),
                crearTarjeta("Piero Ramos", "Supervisor")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(envolver(contenido));
    }

    public void mostrarProductos(){
        VBox contenido = seccionBase("PRODUCTOS", "Catálogo disponible en tienda 🎁");
        HBox tarjetas = new HBox(16);
        tarjetas.setAlignment(Pos.CENTER_LEFT);
        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "S/ 2500"),
                crearTarjeta("Mouse Logitech", "S/ 80"),
                crearTarjeta("Teclado Mecánico", "S/ 180")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(envolver(contenido));
    }

    public void mostrarReportes(){
        VBox contenido = seccionBase("REPORTES", "Resumen general del sistema 📈");
        HBox tarjetas = new HBox(16);
        tarjetas.setAlignment(Pos.CENTER_LEFT);
        tarjetas.getChildren().addAll(
                crearTarjeta("Ventas del Mes", "S/ 12,300"),
                crearTarjeta("Nuevos Clientes", "34"),
                crearTarjeta("Productos Vendidos", "215")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(envolver(contenido));
    }

    public void mostrarConfiguracion(){
        VBox contenido = seccionBase("CONFIGURACIÓN", "Ajustes generales, a tu gusto 🩰");
        VBox opciones = new VBox(10);
        opciones.getChildren().addAll(
                crearOpcion("🔔  Notificaciones", "Activadas"),
                crearOpcion("🌐  Idioma", "Español"),
                crearOpcion("🎨  Tema", "Rosa pastel"),
                crearOpcion("🔒  Seguridad", "Verificación en dos pasos")
        );
        contenido.getChildren().add(opciones);
        setCenter(envolver(contenido));
    }

    public void mostrarCitas(){
        VBox contenido = seccionBase("CITAS", "Tu agenda del día 🌸");
        HBox tarjetas = new HBox(16);
        tarjetas.setAlignment(Pos.CENTER_LEFT);
        tarjetas.getChildren().addAll(
                crearTarjeta("Cita con Carlos", "10:00 am"),
                crearTarjeta("Cita con Maria", "1:00 pm"),
                crearTarjeta("Cita con Piero", "4:30 pm")
        );
        contenido.getChildren().add(tarjetas);
        setCenter(envolver(contenido));
    }

    // ===== Helpers de estilo =====

    private VBox seccionBase(String tituloTexto, String subtituloTexto){
        VBox contenido = new VBox(18);
        contenido.setPadding(new Insets(35));

        Label titulo = new Label(tituloTexto);
        titulo.setStyle(
                "-fx-font-size: 25px;" +
                        "-fx-font-family: 'Georgia';" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: " + TEXTO_OSCURO + ";"
        );
        Label subtitulo = new Label(subtituloTexto);
        subtitulo.setStyle("-fx-font-size: 13px; -fx-text-fill: #A9718B; -fx-font-style: italic;");

        contenido.getChildren().addAll(titulo, subtitulo);
        return contenido;
    }

    private HBox envolver(VBox contenido){
        HBox wrapper = new HBox(contenido);
        wrapper.setAlignment(Pos.CENTER);
        wrapper.setStyle("-fx-background-color: " + CREMA + ";");
        HBox.setHgrow(contenido, javafx.scene.layout.Priority.ALWAYS);
        return wrapper;
    }

    private VBox crearTarjeta(String titulo, String detalle){
        VBox tarjeta = new VBox(8);
        tarjeta.setPadding(new Insets(20));
        tarjeta.setPrefWidth(185);
        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: " + ROSA_SUAVE + ";" +
                        "-fx-border-width: 1.5;" +
                        "-fx-border-radius: 18;" +
                        "-fx-effect: dropshadow(gaussian, rgba(232,147,179,0.35), 8, 0, 2, 2);"
        );
        Label nombre = new Label(titulo);
        nombre.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-font-family: 'Georgia';" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: " + TEXTO_OSCURO + ";"
        );
        Label info = new Label(detalle);
        info.setStyle("-fx-font-size: 12.5px; -fx-text-fill: " + ROSA_FUERTE + ";");
        tarjeta.getChildren().addAll(nombre, info);
        return tarjeta;
    }

    private HBox crearOpcion(String etiqueta, String valor){
        HBox fila = new HBox();
        fila.setAlignment(Pos.CENTER_LEFT);
        fila.setPrefWidth(400);
        fila.setPadding(new Insets(12, 18, 12, 18));
        fila.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 14;" +
                        "-fx-border-color: " + ROSA_SUAVE + ";" +
                        "-fx-border-width: 1;" +
                        "-fx-border-radius: 14;"
        );

        Label lbl = new Label(etiqueta);
        lbl.setStyle("-fx-font-size: 13px; -fx-text-fill: " + TEXTO_OSCURO + "; -fx-font-weight: bold;");
        lbl.setPrefWidth(220);

        Label val = new Label(valor);
        val.setStyle("-fx-font-size: 13px; -fx-text-fill: " + ROSA_FUERTE + ";");

        fila.getChildren().addAll(lbl, val);
        return fila;
    }

    public Button getBtnInicio(){ return btnInicio; }
    public Button getBtnUsuarios(){ return btnUsuarios; }
    public Button getBtnProductos(){ return btnProductos; }
    public Button getBtnReportes(){ return btnReportes; }
    public Button getBtnConfiguracion(){ return btnConfiguracion; }
    public Button getBtnCitas(){ return btnCitas; }
}