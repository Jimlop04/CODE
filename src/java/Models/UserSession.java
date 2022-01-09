
package Models;

/**
 *
 * @author Jimmy
 */
//Tabla UserSession
public class UserSession {

    private String idUser = "";
    private String nombreUsuario = "";
    private String cargo = "";
    private String nombre = "";
    private String apellido = "";
    private String estado = "";

    //Agregamos un constructor sobrecargado de la tabla UserSession
    public UserSession(String idUser, 
            String nombreUsuario, 
            String cargo,
            String nombre, 
            String apellido, 
            String estado) {
        this.idUser = idUser;
        this.nombreUsuario = nombreUsuario;
        this.cargo = cargo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }
    
    //Constructor de la tabla UserSession
    public UserSession() {
    }

    // Agregamos los Getter y Setters de la tabla UserSeccion
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
