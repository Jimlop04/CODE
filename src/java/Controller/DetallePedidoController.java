
package Controller;

import DAO.DetallePedidoDao;
import Models.DetallePedido;

/**
 *
 * @author Jimmy
 */
//Tabla DetallePedidoController
public class DetallePedidoController {

    DetallePedidoDao detpdao;
    String message;

    public DetallePedidoController() {
        this.message = "";
    }
//Metodo para insertar un detalle de pedido

    public String insertarDetallePedido(String idProducto, String cantidad, String precio) {
        detpdao = new DetallePedidoDao();
        DetallePedido detm = new DetallePedido();
        this.message = "Error en los parametros ingresados";

        detm.setCantidad(cantidad);
        detm.setPrecio(precio);
        detm.setIdProducto(idProducto);

        if (detpdao.insertarDetallePedido(detm)) {
            this.message = "Pedido realizado con exito";
        } else {
            this.message = "error de base de datos";
        }
        return this.message;
    }

    //Metodo para disminuir el Stock 
    public String disminuirStock(String idProducto, String idCantidad) {
        detpdao = new DetallePedidoDao();
        DetallePedido detm = new DetallePedido();
        this.message = "Error en los parametros ingresados";

        detm.setIdProducto(idProducto);
        detm.setCantidad(idCantidad);

        if (detpdao.disminuirStock(detm)) {
            this.message = "Stock actualizado correctamente";
        } else {
            this.message = "Error de base de datos";
        }
        return this.message;
    }

    //Metodo para aumentar el stock
    public String aumentarStock(String idProducto, String idCantidad) {
        detpdao = new DetallePedidoDao();
        DetallePedido detm = new DetallePedido();
        this.message = "Error en los parametros ingresados";

        detm.setIdProducto(idProducto);
        detm.setCantidad(idCantidad);

        if (detpdao.aumentarStock(detm)) {
            this.message = "Stock actualizado correctamente";
        } else {
            this.message = "error de base de datos";
        }
        return this.message;
    }

}
