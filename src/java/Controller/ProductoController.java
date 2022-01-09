
package Controller;

import DAO.ProductoDao;
import Models.Producto;

/**
 *
 * @author Jimmy
 */
//Tabla ProductoController
public class ProductoController {

    ProductoDao pdao;
    String message;

    public ProductoController() {
        this.message = "";
    }

    //Metodo para insertar un producto
    public String insertarProducto(String nombre,
            String stock,
            String precioUnit,
            String idUsuario) {
        pdao = new ProductoDao();
        Producto pd = new Producto();
        this.message = "Error parametros incorrectos";
        pd.setNombre(nombre);
        pd.setCantidad(stock);
        pd.setPrecio(precioUnit);
        pd.setIdUsuario(idUsuario);
        if (pdao.insertarProducto(pd)) {
            this.message = "Producto agregado correctamente";
        } else {
            this.message = "Error al agregar producto.";
        }
        return this.message;
    }

    //Metodo para listar los productos
    public String listarProductos(String idUsuario) {
        pdao = new ProductoDao();
        Producto pd = new Producto();
        pd.setIdUsuario(idUsuario);
        return pdao.listarProductos(pd);
    }

    //Metodo para listar los productos en la tienda
    public String listarProductosTienda(String idUsuario) {
        pdao = new ProductoDao();
        Producto pd = new Producto();
        pd.setIdUsuario(idUsuario);
        return pdao.listarProductosTienda(pd);
    }
}
