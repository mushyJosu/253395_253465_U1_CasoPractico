public class Producto {
    private String nombre;
    private int stock;
    private double precioCompra;
    private Proveedor proveedor;

    public  Producto(String nombre, int stock, double precioCompra,  Proveedor proveedor) {
        this.nombre = nombre;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.proveedor = proveedor;
    }

    //indicar qué devuelve
    public void cambiarProveedor(Proveedor nuevoProveedor){
        this.proveedor = nuevoProveedor;
    }

    //get para leer en otra clase
    public String getNombre() {
        return  nombre;
    }
    public int getStock() {
        return stock;
    }
    public double getPrecioCompra() {
        return precioCompra;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
}
