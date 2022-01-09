
package Models;

/**
 *
 * @author Jimmy
 */
// Tabla DetallePedidoEliminado
public class DetallePedidoEliminado {

    private String idDetallesPedidoEliminado = "";
    private String idPedidoEliminado = "";
    private String idProducto = "";
    private String cantidad = "";
    private String precio = "";

   //Agregamos un constructor sobrecargado de la tabla DetallePedido
    public DetallePedidoEliminado(String idDetallesPedidoEliminado,
            String idPedidoEliminado,
            String idProducto,
            String cantidad,
            String precio) {
        this.idDetallesPedidoEliminado = idDetallesPedidoEliminado;
        this.idPedidoEliminado = idPedidoEliminado;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;

    }
    //Constructor de la tabla DetallePedidoEliminado
    public DetallePedidoEliminado() {
    }

    // Agregamos los Getter y Setters de la tabla DetallePedidoEliminado
    public String getIdDetallesPedidoEliminado() {
        return idDetallesPedidoEliminado;
    }

    public void setIdDetallesPedidoEliminado(String idDetallesPedidoEliminado) {
        this.idDetallesPedidoEliminado = idDetallesPedidoEliminado;
    }

    public String getIdPedidoEliminado() {
        return idPedidoEliminado;
    }

    public void setIdPedidoEliminado(String idPedidoEliminado) {
        this.idPedidoEliminado = idPedidoEliminado;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
