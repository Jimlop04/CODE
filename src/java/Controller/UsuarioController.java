
package Controller;

import DAO.UsuarioDao;
import Models.UserSession;
import Models.Usuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jimmy
 */
public class UsuarioController {
    UsuarioDao usdao;
    String message;

    public UsuarioController() {
        message = "";
    }

//Metodo para insertar un nuevo usuario
    public String insertarUsuario(String nombres,
            String apellidos,
            String nombreTienda,
            String estado,
            String tipoUsuario,
            String usuario,
            String contrasenia) {
        usdao = new UsuarioDao();
        Usuario us = new Usuario();
        this.message = "Error en los parametros de entrada.";
        us.setNombres(nombres);
        us.setApellidos(apellidos);
        us.setNombreTienda(nombreTienda);
        us.setEstado(estado);
        us.setTipoUsuario(tipoUsuario);
        us.setUsuario(usuario);
        us.setContrasenia(contrasenia);
        if (usdao.insertarUsuario(us)) {
            this.message = "Usuario registrado correctamente.";
        } else {
            this.message = "Erro al agregar un nuevo usuario.";
        }
        return this.message;
    }

    //Metodo para Habilitar un usuario
    public String habilitarUsuario(String idUsuario) {
        usdao = new UsuarioDao();
        Usuario us = new Usuario();
        this.message = "Error en los parametros de entrada.";
        us.setIdUsuario(idUsuario);
        if (usdao.habilitar(us)) {
            this.message = "Usuario habilitado correctamente";
        } else {
            this.message = "Error al habilitar el usuario";
        }
        return this.message;
    }

    //Metodo para iniciar session 
    public UserSession login(String usuario, String contraseña) {
        UserSession usr = null;
        usdao = new UsuarioDao();
        DefaultTableModel employeeresponse = usdao.login(usuario, contraseña);
        if (employeeresponse.getRowCount() > 0) {
            usr = new UserSession();
            usr.setIdUser(employeeresponse.getValueAt(0, 0).toString());
            usr.setNombre(employeeresponse.getValueAt(0, 1).toString());
            usr.setApellido(employeeresponse.getValueAt(0, 2).toString());
            usr.setNombreUsuario(employeeresponse.getValueAt(0, 6).toString());
            usr.setCargo(employeeresponse.getValueAt(0, 5).toString());
            usr.setEstado(employeeresponse.getValueAt(0, 4).toString());
        } else {
            usr = null;
        }
        return usr;
    }

//Metodo para listar los usuarios
    public String listarUsuarios() {
        usdao = new UsuarioDao();
        return usdao.listarUsuarios();
    }

}
