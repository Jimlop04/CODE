
package DAO;

import DataStatic.Conection;
import Models.Producto;

/**
 *
 * @author Jimmy
 */
//Tabla ProductoDao
public class ProductoDao {

    Conection conex;
    String sql = "";

    public ProductoDao() {
        conex = new Conection();
    }

    //Metodo insertar Producto
    public boolean insertarProducto(Producto pc) {
        sql = String.format("insert into producto"
                + "(nombre, stock, precio_unit, usuario_id_usuario) "
                + "values('%s', %s, %s, %s)",
                pc.getNombre(),
                pc.getCantidad(),
                pc.getPrecio(),
                pc.getIdUsuario());
        return conex.modifyBD(sql);
    }

    //Metodo listar Producto
    public String listarProductos(Producto pc) {
        sql = "select * from producto where usuario_id_usuario = "
                + pc.getIdUsuario() + " and stock > 0 order by id_producto asc";
        return conex.getRecordsInJson(sql);
    }

    //Metodo listar productos de la tienda
    public String listarProductosTienda(Producto pc) {
        sql = "select * from producto where usuario_id_usuario = "
                + pc.getIdUsuario() + " and stock > 0 order by id_producto asc";
        return conex.getRecordsInJson(sql);
    }

}
