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
        view.getBtnRegistrar().setOnAction(e->{
            registrarUsuario();
        });

        view.getBtnActualizar().setOnAction(e->{
            actualizarUsuario();
        });

        view.getBtnEliminar().setOnAction(e-> {
            eliminarUsuario();
        });

        // SELECCIÓN + CARGA: al seleccionar una fila (clic o teclado)
        // se llenan automáticamente los campos del formulario
        view.getTablaUsuarios()
                .getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        view.cargarUsuarioEnFormulario(seleccionado);
                    }
                });

    }
    private void cargarUsuarios(){
        List<Usuario> usuarios = usuarioDAO.listar();
        view.mostrarDatosUsuarios(usuarios);
    }
    private void registrarUsuario(){
        if (!formularioValido()) {
            return;
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(view.getNombre());
        usuario.setApellido(view.getApellido());
        usuario.setCorreo(view.getCorreo());
        usuario.setEstado(view.getEstado());
        usuarioDAO.insertar(usuario);
        cargarUsuarios();
        view.limpiarFormulario();
    }
    private void actualizarUsuario(){
        Usuario usuario = view.getUsuarioSeleccionado();
        if ( usuario == null){
            view.mostrarMensaje("Seleccione un usuario de la tabla.");
            return;
        }
        if (!formularioValido()) {
            return;
        }
        usuario.setNombre(view.getNombre());
        usuario.setApellido(view.getApellido());
        usuario.setCorreo(view.getCorreo());
        usuario.setEstado(view.getEstado());

        usuarioDAO.actualizar(usuario);   // UPDATE
        cargarUsuarios();                 // Refresco inmediato de la tabla
        view.limpiarFormulario();
    }
    private void eliminarUsuario(){
        Usuario usuario = view.getUsuarioSeleccionado();
        if ( usuario == null){
            view.mostrarMensaje("Seleccione un usuario de la tabla.");
            return;
        }
        if (!view.confirmar("¿Eliminar a " + usuario.getNombre() + " " + usuario.getApellido() + "?")) {
            return;
        }
        usuarioDAO.eliminar(usuario.getId());   // DELETE
        cargarUsuarios();                       // Refresco inmediato de la tabla
        view.limpiarFormulario();
    }

    // Valida que ningún campo del formulario esté vacío
    private boolean formularioValido(){
        if (view.getNombre().isBlank() || view.getApellido().isBlank()
                || view.getCorreo().isBlank() || view.getEstado().isBlank()) {
            view.mostrarMensaje("Complete todos los campos.");
            return false;
        }
        return true;
    }
}
