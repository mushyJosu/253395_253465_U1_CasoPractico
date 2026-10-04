import java.util.Scanner;

public class Main {
    private static final Scanner teclado = new Scanner(System.in);
    private static final int CAPACIDAD= 5; //se define el tamaño del array

    public static void main(String[] args) {
        System.out.println("Sistema De Almacen De Productos.");

        Almacen almacen = new Almacen(CAPACIDAD);
        Encargado encargado = new Encargado();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: " , 0);

            switch (opcion) {
                case 1:
                    registrarEntradaProducto(almacen);
                    break;
                case 2:
                    cambiarProveedorDeProducto(almacen, encargado);
                    break;
                case 3:
                    encargado.generarReporteEntradaProductos(almacen);
                    break;
                case 0:
                    System.out.println("Saliendo del almacen");
                    break;
                default:
                    System.out.println("Opción no válida. Tienes que elegir un número del menú");
            }
        } while (opcion != 0);
    }

    // Menú del almacen
    private static void mostrarMenu() {
        System.out.println("\nBienvenido al menú");
        System.out.println("1. Registrar entrada de un producto");
        System.out.println("2. Cambiar proveedor de un producto");
        System.out.println("3. Generar reporte de entrada de productos");
        System.out.println("0. Salir");
    }


    // Se empiza a registrar la entrada de los productos
    private static void registrarEntradaProducto(Almacen almacen) {
        System.out.println("\nRegistrar entrada de un producto:");

        Proveedor proveedor = leerProveedor();   //Registrar datos del proveedor

        String nombre = leerTexto("Nombre del producto: ");
        int stock = leerEntero("Stock: ", 0);
        double precioCompra = leerDecimal("Precio de compra acordado: ");

        //Se pasan los valores al producto
        Producto producto = new Producto(nombre, stock, precioCompra, proveedor);

        if (almacen.registrarProducto(producto)) {
            System.out.println("Producto registrado correctamente");
        } else {
            System.out.println("El almacén está lleno, no se pudo registrar el producto");
        }
    }

    // Cambiar proveedor de un producto
    private static void cambiarProveedorDeProducto(Almacen almacen, Encargado encargado) {
        System.out.println("\nCambiar proveedor de un producto:");

        int cantidad = almacen.obtenerCantidadProductos();
        if (cantidad == 0) {
            System.out.println("No hay productos registrados");
            return;   // termina el metodo
        }

        // Se muestra el reporte para que el usuario vea el número de cada producto
        encargado.generarReporteEntradaProductos(almacen);

        int numero = leerEntero("Número del producto a modificar: ", 1);
        if (numero > cantidad) {
            System.out.println("No existe el producto #" + numero);
            return;
        }

        System.out.println("\nDatos del nuevo proveedor:");
        Proveedor nuevoProveedor = leerProveedor();

        almacen.cambiarProveedor(numero - 1, nuevoProveedor);
        System.out.println("Proveedor actualizado correctamente");
    }


    private static Proveedor leerProveedor() {
        String empresa = leerTexto("Nombre de la empresa proveedora: ");
        String repartidor = leerTexto("Nombre del repartidor: ");
        String telefono = leerTexto("Teléfono de contacto: ");
        return new Proveedor(empresa, repartidor, telefono);
    }


    private static int leerEntero(String mensaje, int minimo) {
        while (true) {
            System.out.print(mensaje);
            String linea = teclado.nextLine().trim();
            try {
                int valor = Integer.parseInt(linea);
                if (valor >= minimo) {
                    return valor;
                }
                System.out.println("Escribe un número entero mayor o igual a " + minimo );
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número entero válido");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = teclado.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(linea);
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("El valor no puede ser negativo");
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número válido");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = teclado.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Este dato no puede estar vacío");
        }
    }
}