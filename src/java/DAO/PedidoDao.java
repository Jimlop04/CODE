
package DAO;

import DataStatic.Conection;
import Models.Pedido;

/**
 *
 * @author Jimmy
 */
//Tabla pedidoDao
public class PedidoDao {

    Conection conex;
    String sql = "";

    public PedidoDao() {
        conex = new Conection();
    }

    //Metodo para insertar un pedido nuevo
    public boolean insertarPedido(Pedido pd) {
        sql = String.format("insert into encabezado_pedido "
                + "(fecha_venta, estado, usuario_id_usuario, total, descuento) "
                + "values (now(),'%s',%s, %s, %s)",
                pd.getEstado(),
                pd.getIdUsuario(),
                pd.getTotal(),
                pd.getDescuento());
        return conex.modifyBD(sql);
    }

    //Metodo que nos devuelve la cantidad de ventas por el mes 
    public String cantidadVentasPorMes(String id_usuario) {
        sql = String.format("select count(idEncapedido) \n"
                + "from encabezado_pedido "
                + "where DATE_PART('day', now() - fecha_venta) <= 30 "
                + "and usuario_id_usuario = %s",
                id_usuario);
        return conex.fillString(sql);
    }

    //Metodo cancelar pedido
    public boolean cancelarPedido(Pedido pd) {
        sql = String.format("delte from encabezado_pedido "
                + "where idEncapedido = %s",
                pd.getIdPedido());
        return conex.modifyBD(sql);
    }

    //Metodo que nos permite listar los pedidos
    public String listarPedidos(String idUsuario) {
        sql = "select distinct ep.idEncapedido,ep.fechaVenta, us.nombreTienda,"
                + "ep.total, ep.descuento, ep.estado\n"
                + "from encabezadoPedido as ep inner join detallePedido "
                + "as dp on ep.idEncapedido = "
                + "dp.encabezado_pedido_id_encapedido\n"
                + "inner join producto as pr "
                + "on dp.producto_id_producto = pr.idProducto \n"
                + "inner join usuario as us "
                + "on pr.usuario_id_usuario = us.idUsuario\n"
                + "where ep.usuario_id_usuario = " + idUsuario + "\n"
                + "group by ep.total, ep.idEncapedido, dp.idDetpedido, "
                + "pr.idProducto, us.idUsuario "
                + "order by ep.idEncapedido asc";
        return conex.getRecordsInJson(sql);
    }

    //Metodo que nos permite listar los pedidos que han sido cancelados
    public String listarPedidosCancelados(String idUsuario) {
        sql = "select distinct ep.idPedeliminado, ep.fechaPedido, "
                + "ep.fechaPedido, us.nombreTienda, ep.total, ep.descuento, "
                + "ep.descuento\n from encabezado_pedido_eliminado as ep "
                + "inner join detalle_pedido_eliminado "
                + "as dp on ep.idPedeliminado = "
                + "dp.encabezado_pedido_eliminado_id_pedeliminado\n"
                + "inner join producto as pr "
                + "on dp.producto_id_producto = pr.idProducto \n"
                + "inner join usuario as us "
                + "on pr.usuario_id_usuario = us.idUsuario\n"
                + "where ep.usuario_id_usuario = " + idUsuario + "\n"
                + "group by ep.total, ep.idPedeliminado, "
                + "dp.id_detalle_pedelimnado, pr.idProducto, us.idUsuario \n"
                + "order by ep.idPedeliminado asc";
        return conex.getRecordsInJson(sql);
    }

    //Metodo listar pedido de la tienda
    public String listarPedidosTienda(Pedido pd) {
        sql = "select distinct ep.id_encapedido,ep.fecha_venta, ep.total, "
                + "ep.descuento, ep.estado, ep.usuario_id_usuario\n"
                + "from encabezado_pedido as ep inner join detalle_pedido "
                + "as dp on ep.id_encapedido = "
                + "dp.encabezado_pedido_id_encapedido\n"
                + "inner join producto as pr "
                + "on dp.producto_id_producto = pr.id_producto \n"
                + "inner join usuario as us "
                + "on pr.usuario_id_usuario = us.id_usuario\n"
                + "where us.id_usuario = " + pd.getIdUsuario() + "\n"
                + "group by ep.total, ep.id_encapedido, dp.id_detpedido, "
                + "pr.id_producto, us.id_usuario \n"
                + "order by ep.id_encapedido asc";
        System.out.println(sql);
        return conex.getRecordsInJson(sql);
    }

    //Metodo cancelar pedido
    public boolean cancelarPedido(String idPedido) {
        sql = "delete from detalle_pedido "
                + "where encabezado_pedido_id_encapedido = "
                + idPedido + "";
        System.out.println(sql);
        if (conex.modifyBD(sql)) {
            sql = "delete from encabezado_pedido where id_encapedido = "
                    + idPedido + "";
        }
        return conex.modifyBD(sql);
    }

    //Metodo despachar pedido
    public boolean despacharPedido(String id_pedido) {
        sql = "update encabezado_pedido set estado = 'd' where id_encapedido = "
                + id_pedido + "";
        System.out.println(sql);
        return conex.modifyBD(sql);
    }

}
