
public class Encargado {
    public Encargado() {
    }
    public void generarReporteEntradaProductos(Almacen almacen){

        int cantidad = almacen.obtenerCantidadProductos();
        if(cantidad == 0){
            System.out.println("No hay registros de productos: " + cantidad);
        }
        for (int i = 0; i < cantidad; i++){
            Producto producto = almacen.obtenerProducto(i);
            Proveedor proveedor = producto.getProveedor();
            System.out.println("Producto #" + (1+i));
            System.out.println("Reporte De Productos:");
            System.out.println("Nombre:" + producto.getNombre() );
            System.out.println("Stock:" + producto.getStock());
            System.out.println("Precio compra:" + producto.getPrecioCompra());
            System.out.println("Empresa:" + proveedor.getNombreEmpresa());
            System.out.println("Repartidor:" + proveedor.getNombreRepartidor());
            System.out.println("Telefono:" + proveedor.getTelefonoContacto());
        }
        }
    }
