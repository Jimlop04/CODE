package DAO;

import DataStatic.Conection;
import Models.DetallePedidoEliminado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jimmy
 */
//Tabla DetallePedidoEliminado
public class DetallePedidoEliminadoDao {

    Conection conex;
    String sql = "";

    public DetallePedidoEliminadoDao() {
        conex = new Conection();
    }

    //Metodo para insertar un detalle de un pedido ya eliminado
    public boolean insertarDetallePedidoEliminado(DetallePedidoEliminado detpe){
        sql = String.format("insert into detalle_pedido_eliminado "
                + "(cantidad, precio_unit, "
                + "encabezado_pedido_eliminado_id_pedeliminado, "
                + "producto_id_producto)"+ "values(%s, %s, "
                + "(select id_pedeliminado from encabezado_pedido_eliminado "
                + "order by id_pedeliminado desc limit 1), %s)",
                detpe.getCantidad(),
                detpe.getPrecio(),
                detpe.getIdProducto());
        return conex.modifyBD(sql);
    }

    //Metodo para obtener un producto eliminado
    public DefaultTableModel getProductos(String id_pedido) {
        sql = "select * from detalle_pedido "
                + "where encabezado_pedido_id_encapedido = "
                + id_pedido + "";
        System.out.println(sql);
        return conex.returnRecord(sql);
    }

}
