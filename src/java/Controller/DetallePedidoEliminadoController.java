
package Controller;

import DAO.DetallePedidoEliminadoDao;
import Models.DetallePedidoEliminado;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jimmy
 */
//Tabla DetallePedidoEliminadocontroller
public class DetallePedidoEliminadoController {

    DetallePedidoEliminadoDao dpedao;
    String message;

    public DetallePedidoEliminadoController() {
        this.message = "";
    }

    //Metodo para insertar un detalle del pedido eliminado
    public String insertarDetallePedidoEliminado(String cantidad,String precio,
            String idProducto) {
        dpedao = new DetallePedidoEliminadoDao();
        DetallePedidoEliminado detpe = new DetallePedidoEliminado();
        this.message = "Error en los parametros ingresados";

        detpe.setCantidad(cantidad);
        detpe.setPrecio(precio);
        detpe.setIdProducto(idProducto);

        if (dpedao.insertarDetallePedidoEliminado(detpe)) {
            this.message = "correcto";
        } else {
            this.message = "error en la base de datos";
        }

        return this.message;
    }

    //Metodo para obtener el producto eliminado 
    public String getProductos(String idPedido) {
        dpedao = new DetallePedidoEliminadoDao();
        DefaultTableModel table = dpedao.getProductos(idPedido);
        String detalle = "";
        for (int i = 0; i < table.getRowCount(); i++) {
            detalle += table.getValueAt(i, 4).toString() + ";"
                    + table.getValueAt(i, 1).toString() + ";"
                    + table.getValueAt(i, 3).toString();
            if (i < table.getRowCount() - 1) {
                detalle += "/";
            }
        }
        System.out.println(detalle);
        return detalle;
    }

}
