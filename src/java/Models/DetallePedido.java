
package Models;

/**
 *
 * @author Jimmy
 */
//Tabla DetallePedido
public class DetallePedido {

    private String idDetallePedidos = "";
    private String idPedido = "";
    private String idUsuario = "";
    private String idProducto = "";
    private String precio = "";
    private String cantidad = "";

    //Agregamos un constructor sobrecargado de la tabla DetallePedido
    public DetallePedido(String idDetallePedidos,
            String id_Pedido,
            String idUsuario,
            String idProducto,
            String precio,
            String cantidad) {
        this.idDetallePedidos = idDetallePedidos;
        this.idPedido = id_Pedido;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;

    }

//Constructor de la tabla DetallePedido
    public DetallePedido() {
    }

    // Agregamos los Getter y Setters de la tabla DetallePedido
    public String getIdDetallePedidos() {
        return idDetallePedidos;
    }

    public void setIdDetallePedidos(String idDetallePedidos) {
        this.idDetallePedidos = idDetallePedidos;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}
