
package Controller;

import DAO.PedidoEliminadoDao;
import Models.PedidoEliminado;

/**
 *
 * @author Jimmy
 */
//Tabla PedidoEliminadoController
public class PedidoEliminadoController {
    PedidoEliminadoDao pedao;
    String message;

    public PedidoEliminadoController() {
        this.message = "";
    }

    //Metodo para insertar un pedido ya eliminado
    public String insertarPedidoEliminado(String fechaPedido,
            String idUsuario,
            String descuento,
            String total) {
        pedao = new PedidoEliminadoDao();
        PedidoEliminado pe = new PedidoEliminado();

        this.message = "Error en los parametros ingresados";
        pe.setFechaPedido(fechaPedido);
        pe.setIdUsuario(idUsuario);
        pe.setDescuento(descuento);
        pe.setTotal(total);

        if (pedao.insertarPedidoEliminado(pe)) {
            this.message = "corecto";
        } else {
            this.message = "error de base dedatos";
        }

        return this.message;
    }

}
