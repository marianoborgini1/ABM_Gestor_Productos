public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private ProductoCategoria categoria;


    public Producto(String nombre, ProductoCategoria categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // mostrar información en consola
    public void mostrarInfo() {
        System.out.println("Producto: " + nombre);
        System.out.println("Categoría: " + categoria); 
        System.out.println("Precio : " + precio);
        System.out.println("Stock: " + stock); 
    }

    @Override 
    public String toString(){
        return "Producto: " + nombre + " - Categoria: " + categoria + " - Precio: $" + precio + " - Stock: " + stock;
    }

    // Getters y Setters 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() { 
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ProductoCategoria categoria) {
        this.categoria = categoria;
    }
}
