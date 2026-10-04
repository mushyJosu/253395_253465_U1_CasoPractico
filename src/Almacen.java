public class Almacen {
    private Producto[] productos;
    private int contadorProductos;

    //inicializar constructor
    public Almacen(int capacidad) {
        this.productos = new Producto[capacidad];
        this.contadorProductos = 0;
    }

    public int obtenerCantidadProductos(){
        return contadorProductos;
    }

    public boolean registrarProducto(Producto producto){
        if (contadorProductos < productos.length){
            productos[contadorProductos] = producto;
            contadorProductos++;
            return true;
        }
        return false;
    }

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
}

