package DAO;

import DataStatic.Conection;
import Models.Usuario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jimmy
 */
//Tabla UsuarioDao
public class UsuarioDao {

    Conection conex;
    String sql = "";

    public UsuarioDao() {
        conex = new Conection();
    }

    //Metodo insertar usuario
    public boolean insertarUsuario(Usuario us) {
        sql = String.format("insert into usuario (nombres, apellidos, "
                + "nombre_tienda, estado, tipo_usuario,usuario, contrasenia) "
                + "values('%s','%s','%s','%s','%s','%s','%s')",
                us.getNombres(),
                us.getApellidos(),
                us.getNombreTienda(),
                us.getEstado(),
                us.getTipoUsuario(),
                us.getUsuario(),
                us.getContrasenia());
        return conex.modifyBD(sql);
    }

    //Metodo para habilitar el usuario
    public boolean habilitar(Usuario us) {
        sql = "update usuario set estado = 'a' where id_usuario = "
                + us.getIdUsuario() + "";
        return conex.modifyBD(sql);
    }

    //Metodo que retorna un usuario 
    public DefaultTableModel login(String nombre_user, String contrasenia) {
        sql = "select * from usuario where usuario = '"
                + nombre_user + "' and contrasenia = '"
                + contrasenia + "'";
        System.out.println(sql);
        return conex.returnRecord(sql);
    }

    //Metodo para listar los usuarios de la base de datos
    public String listarUsuarios() {
        sql = "select * from usuario order by id_usuario";
        return conex.getRecordsInJson(sql);
    }

}
