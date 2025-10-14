import java.time.LocalDate;

public class ProductoElectronico extends Producto{
    private LocalDate garantia;
    
    public ProductoElectronico(String nombre, double precio, int stock, ProductoCategoria categoria, LocalDate garantia){
        super(nombre, categoria, precio, stock);
        this.garantia = garantia;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Garantia hasta: " + garantia);
    }

    public LocalDate getGarantia(){
        return garantia;
    }

    public void setGarantia(LocalDate garantia){
        this.garantia = garantia;
    }



}
