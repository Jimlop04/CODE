
package DAO;

import DataStatic.Conection;
import Models.PedidoEliminado;

/**
 *
 * @author Jimmy
 */
//Tabla PedidoEliminado
public class PedidoEliminadoDao {

    Conection conex;
    String sql = "";

    public PedidoEliminadoDao() {
        conex = new Conection();
    }

    //Metodo que se inicia cuando se elimina un pedido
    public boolean insertarPedidoEliminado(PedidoEliminado pe) {
        sql = String.format("insert into encabezado_pedido_eliminado "
                + "(fecha_eliminar, fecha_pedido, usuario_id_usuario, "
                + "descuento, total) values(now(), '%s', %s, %s, %s)",
                pe.getFechaPedido(),
                pe.getIdUsuario(),
                pe.getDescuento(),
                pe.getTotal());
        return conex.modifyBD(sql);
    }
}
