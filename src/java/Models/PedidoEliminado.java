
package Models;

/**
 *
 * @author Jimmy
 */
//Tabla PedidoEliminado 
public class PedidoEliminado {

    private String idPedidoEliminado = "";
    private String idUsuario = "";
    private String fechaEliminado = "";
    private String fechaPedido = "";
    private String descuento = "";
    private String total = "";

    //Agregamos un constructor sobrecargado de la tabla PedidoEliminado
    public PedidoEliminado(String idPedidoEliminado,
            String idUsuario,
            String fechaEliminado,
            String fechaPedido,
            String descuento,
            String total) {
        this.idPedidoEliminado = idPedidoEliminado;
        this.idUsuario = idUsuario;
        this.fechaEliminado = fechaEliminado;
        this.fechaPedido = fechaPedido;
        this.descuento = descuento;
        this.total = total;
    }

    //Constructor de la tabla PedidoEliminado
    public PedidoEliminado() {
    }

    // Agregamos los Getter y Setters de la tabla PedidoEliminado
    public String getIdPedidoEliminado() {
        return idPedidoEliminado;
    }

    public void setIdPedidoEliminado(String idPedidoEliminado) {
        this.idPedidoEliminado = idPedidoEliminado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaEliminado() {
        return fechaEliminado;
    }

    public void setFechaEliminado(String fechaEliminado) {
        this.fechaEliminado = fechaEliminado;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
