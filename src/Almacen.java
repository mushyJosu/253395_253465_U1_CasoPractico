public class Almacen {
    private Producto[] productos;
    private int contadorProductos;

    //inicializar constructor
    public Almacen(int CAPACIDAD) {
        this.productos = new Producto[CAPACIDAD];
        this.contadorProductos = 0;
    }

    public int obtenerCantidadProductos(){

        return contadorProductos;
    }

    public boolean registrarProducto(Producto producto){
        if (contadorProductos < productos.length){
            productos[contadorProductos] = producto; //registra
            contadorProductos++;  //increment
            return true;
        }
        return false;
    }
    // Obtiene un producto mediante su índice en el arreglo.
    public Producto obtenerProducto(int indice){
        if (indice >= 0 && indice < contadorProductos){
            return productos[indice];
        }
        return null;
    }

    public void cambiarProveedor (int indice, Proveedor nuevoProveedor){
        if (indice >= 0 && indice < contadorProductos){
            productos[indice].cambiarProveedor(nuevoProveedor);
        } else {
            System.out.println("No existe la posicion: " + indice);
        }
    }

    public void generarReporteEntradaProductos(){
        int cantidad = contadorProductos;
        if(cantidad == 0){
            System.out.println("No hay registros de productos: " + cantidad);
        }
        for (int i = 0; i < cantidad; i++){
            Producto producto = productos[i];
            Proveedor proveedor = producto.getProveedor();
            System.out.println("Producto #" + (1+i));
            System.out.println("Reporte De Productos:");
            System.out.println("Nombre:" + producto.getNombre() );
            System.out.println("Stock:" + producto.getStock());
            System.out.printf("Precio compra: $%.2f%n", producto.getPrecioCompra());
            System.out.println("Empresa:" + proveedor.getNombreEmpresa());
            System.out.println("Repartidor:" + proveedor.getNombreRepartidor());
            System.out.println("Telefono:" + proveedor.getTelefonoContacto());
        }
    }
}

