package DAO;

import DataStatic.Conection;
import Models.DetallePedido;

/**
 *
 * @author Jimmy
 */
//Tabla DetallePedidoDao
public class DetallePedidoDao {

    Conection conex;
    String sql = "";

    public DetallePedidoDao() {
        conex = new Conection();
    }

    //Metodo para insertar un detalle del pedido
    public boolean insertarDetallePedido(DetallePedido detp) {
        sql = String.format("insert into detalle_pedido "
                + "(producto_id_producto, cantidad, precio_unit, "
                + "encabezado_pedido_id_encapedido) "
                + "values (%s, %s, %s, (select id_encapedido "
                + "from encabezado_pedido order by id_encapedido desc limit 1))",
                detp.getIdProducto(),
                detp.getCantidad(),
                detp.getPrecio());
        return conex.modifyBD(sql);
    }

    //Metodo para cancelar un pedido
    public boolean cancelarPedido(DetallePedido detp) {
        sql = String.format("delte from detalle_pedido "
                + "where encabezado_pedido_id_encapedido = %s",
                detp.getIdPedido());
        return conex.modifyBD(sql);
    }

    //Metodo para disminuir el stock de productos
    public boolean disminuirStock(DetallePedido detp) {
        sql = String.format("update producto set stock = stock - %s "
                + "where id_producto = %s",
                detp.getCantidad(),
                detp.getIdProducto());
        return conex.modifyBD(sql);
    }
    //Metodo para aumentar el stock de productos

    public boolean aumentarStock(DetallePedido detp) {
        sql = String.format("update producto set stock = stock + %s "
                + "where id_producto = %s",
                detp.getCantidad(),
                detp.getIdProducto());
        return conex.modifyBD(sql);
    }

}
