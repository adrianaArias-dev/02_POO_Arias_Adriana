package vallegrande.edu.pe.misistema.controller;

import vallegrande.edu.pe.misistema.model.Usuario;
import vallegrande.edu.pe.misistema.model.UsuarioDAO;
import vallegrande.edu.pe.misistema.view.MainView;

import java.util.List;

public class MainController {

    private MainView view;
    private UsuarioDAO usuarioDAO;

    public MainController(MainView view){
        this.view = view;
        usuarioDAO = new UsuarioDAO();
        configurarEventos();
    }
    public void configurarEventos() {
        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });
        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
            cargarUsuarios();
        });
        view.getBtnGuardar().setOnAction(e -> guardarUsuario());
    }
    private void cargarUsuarios(){
        List<Usuario> usuarios = usuarioDAO.listar();
        view.mostrarDatosUsuarios(usuarios);
    }

    // Toma los datos del formulario, valida, inserta en MySQL y refresca la tabla
    private void guardarUsuario() {
        Usuario u = view.obtenerUsuarioFormulario();

        if (u.getNombre().isEmpty() || u.getApellido().isEmpty() || u.getCorreo().isEmpty()) {
            view.mostrarMensaje("Completa nombre, apellido y correo.", false);
            return;
        }

        if (!u.getCorreo().contains("@")) {
            view.mostrarMensaje("El correo no es válido.", false);
            return;
        }

        if (usuarioDAO.insertar(u)) {
            view.limpiarFormulario();
            cargarUsuarios();   // vuelve a consultar MySQL y actualiza el TableView
            view.mostrarMensaje("Usuario registrado correctamente.", true);
        } else {
            view.mostrarMensaje("No se pudo registrar el usuario. Revisa la consola.", false);
        }
    }
}
