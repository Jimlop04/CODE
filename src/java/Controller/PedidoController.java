
package Controller;

import DAO.PedidoDao;
import Models.Pedido;

/**
 *
 * @author Jimmy
 */
//Tabla PedidoController
public class PedidoController {

    PedidoDao pedao;
    String message;

    public PedidoController() {
        this.message = "";
    }

    //Metodo para insertar un pedido
    public String insertarPedido(String estado,String idUsuario,String total) {
        pedao = new PedidoDao();
        Pedido pe = new Pedido();

        this.message = "Error en los parametros de entrada";

        pe.setEstado(estado);
        pe.setIdUsuario(idUsuario);
        pe.setTotal(total);

        //validacion de los descuentos
        int descuento = Integer.parseInt(pedao.cantidadVentasPorMes(idUsuario));
        pe.setDescuento(descuento == 0 ? descuento : 
                (descuento > 0 && descuento < 11) ? descuento : 10);

        if (pedao.insertarPedido(pe)) {
            this.message = "procesando...";
        } else {
            this.message = "error de base de datos";
        }
        return this.message;
    }

    //Metodo para Listar un Pedido
    public String listarPedidos(String idUsuario) {
        pedao = new PedidoDao();
        return pedao.listarPedidos(idUsuario);
    }

    //Metodo para Listar un pedido ya Cancelado
    public String listarPedidosCancelados(String idUsuario) {
        pedao = new PedidoDao();
        return pedao.listarPedidosCancelados(idUsuario);
    }

    //Metodo para Listar un Pedido de la tienda
    public String listarPedidosTienda(String idUsuario) {
        pedao = new PedidoDao();
        Pedido pe = new Pedido();

        pe.setIdUsuario(idUsuario);
        return pedao.listarPedidosTienda(pe);
    }

    //Metodo para Cancelar un pedido
    public String cancelarPedido(String idPedido) {
        pedao = new PedidoDao();
        if (pedao.cancelarPedido(idPedido)) {
            this.message = "Pedido cancelado correctamente";
        } else {
            this.message = "error";
        }
        return this.message;
    }

    //Metodo para despachar un Pedido
    public String despacharPedido(String id_pedido) {
        pedao = new PedidoDao();
        if (pedao.despacharPedido(id_pedido)) {
            this.message = "Pedido despachado correctamente";
        } else {
            this.message = "error";
        }
        return this.message;
    }

    //Metodo para obtener el descuento 
    public String cantidadDescuento(String id_usuario) {
       pedao = new PedidoDao();
       int descuento = Integer.parseInt(pedao.cantidadVentasPorMes(id_usuario));
       int descuento_response = (descuento == 0 ? descuento : 
               (descuento > 0 && descuento < 11) ? descuento : 10);
       return String.valueOf(descuento_response);
    }

}
