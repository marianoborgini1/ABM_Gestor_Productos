import java.util.Scanner;
import java.time.LocalDate;
public class App {
    public static void main(String[] args) throws Exception {

        Tienda tienda = new Tienda();
        Scanner sc = new Scanner(System.in);
        int option;

        do {

            // 1. Mostrar el menú de opciones
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Borrar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Buscar producto");
            System.out.println("5. Salir");

            System.out.print("Elige una opción: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:

                    System.out.println("Ingrese producto: ");
                    String nombreProducto = sc.nextLine();

                    System.out.println("Categoria: ALIMENTICIO - HOGAR - ELECTRONICO - NINGUNA ");
                    System.out.println("Ingrese la categoria: ");
                    String categoriaTemp = sc.nextLine();
                    

                    try {
                        ProductoCategoria categoria = ProductoCategoria.valueOf(categoriaTemp.trim().toUpperCase());

                        if (categoriaTemp.equalsIgnoreCase("ALIMENTICIO")){
                        System.out.println("Ingrese precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Ingrese stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Ingrese la fecha de vencimiento: AAAA-MM-DD");
                        // Convertimos de String a localDate
                        String fechaVen = sc.nextLine();
                        LocalDate vencimiento = LocalDate.parse(fechaVen);

                        ProductoAlimenticio productoA = new ProductoAlimenticio(nombreProducto, precio, stock, categoria ,vencimiento, false);
                        productoA.mostrarInfo();
                        tienda.agregarProducto(productoA);

                    } else if ( (categoriaTemp.equalsIgnoreCase("HOGAR")) || (categoriaTemp.equalsIgnoreCase("ELECTRONICO"))) {
                        System.out.println("Ingrese precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Ingrese stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Ingrese la fecha de garantia: AAAA-MM-DD");
                        // Convertimos de String a localDate
                        String fechaGarantia = sc.nextLine();
                        LocalDate garantiaVenc = LocalDate.parse(fechaGarantia);
                        
                        ProductoConGarantia productoG = new ProductoConGarantia(nombreProducto, precio, stock, categoria, garantiaVenc, false);
                        productoG.mostrarInfo();
                        tienda.agregarProducto(productoG);

                    } else if ((categoriaTemp.equalsIgnoreCase("NINGUNA"))) {
                        
                        System.out.println("Ingrese precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Ingrese stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine();

                        Producto productoSinCategoria = new Producto(nombreProducto, categoria, precio, stock);
                        productoSinCategoria.mostrarInfo();
                        tienda.agregarProducto(productoSinCategoria);

                    } 

                    } catch (IllegalArgumentException e) {
                        System.out.println("Categoria no encontrada...");
                    }

                    break;
                
                case 2:

                    System.out.println("ingrese el producto a borrar: ");
                    String productoBorrar = sc.nextLine();
                    tienda.borrarProducto(productoBorrar);

                case 3:

                    tienda.listarProductos();

                    break;
                
                case 4:

                    System.out.println("Ingrese el producto que quiere buscar: ");
                    String nombreBuscar = sc.nextLine();

                    Producto encontrado = tienda.buscarProducto(nombreBuscar);

                    if (encontrado != null){
                        System.out.println("--- Producto Encontrado ---");
                        if (encontrado instanceof ProductoAlimenticio){
                            ((ProductoAlimenticio) encontrado).mostrarInfo();
                        } else if (encontrado instanceof ProductoConGarantia) {
                            ((ProductoConGarantia) encontrado).mostrarInfo();
                        } else {
                            encontrado.mostrarInfo();
                        }
                    }

                    break;
            
                default:
                    break;
            }


        } while (option != 5);

            System.out.println("Saliedo del sistema...");
            sc.close();
       
    }

}
