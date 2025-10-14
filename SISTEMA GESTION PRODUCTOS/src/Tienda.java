import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> productos;

    public Tienda() {
        this.productos = new ArrayList<>();

        // Productos pre-cargados para pruebas 
        productos.add(new Producto("Arroz", ProductoCategoria.ALIMENTICIO, 150.0, 10));
        productos.add(new Producto("Jabón", ProductoCategoria.HOGAR, 50.0, 20));
        productos.add(new Producto("Auriculares", ProductoCategoria.ELECTRONICO, 1200.0, 5));
        productos.add(new Producto("Leche", ProductoCategoria.ALIMENTICIO, 120.0, 15));
        productos.add(new Producto("Lavandina", ProductoCategoria.HOGAR, 80.0, 30));
        productos.add(new Producto("Mouse", ProductoCategoria.ELECTRONICO, 900.0, 7));
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado con exito: " + p.getNombre());
    }

    public Producto buscarProducto(String nombre) {
        // Itera sobre cada producto en la lista.
        for (Producto p : productos) {
            // Compara el nombre del producto actual con el nombre que se busca.
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p; // Retorna el producto si lo encuentra.
            }
        }
        return null; // Retorna null si el bucle termina sin encontrar el producto.
    }

    public void listarProductos() {
        System.out.println("--- Lista de Productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda.");
        } else {
            for (Producto p : productos) {
                // Asume que la clase Producto tiene un método toString() para una impresión legible.
                System.out.println(p);
            }
        }
        System.out.println("-----------------");
    }

    public Producto borrarProducto(String nombre) {
        // Busca el producto. Si existe, se guarda en 'productoABorrar'.
        Producto productoABorrar = buscarProducto(nombre);

        if (productoABorrar != null) {
            productos.remove(productoABorrar);
            System.out.println("Producto " + nombre + " borrado con éxito.");
            return productoABorrar; // Devuelve el producto borrado.
        } else {
            System.out.println("No se encontró el producto " + nombre + " para borrar.");
            return null; // Devuelve null si no se encontró.
        }
    }
}