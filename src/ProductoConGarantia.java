import java.time.LocalDate;

public class ProductoConGarantia extends Producto{
    private LocalDate garantia;
    private boolean garantiaVencida;
    private LocalDate fechaActual = LocalDate.now();
    
    public ProductoConGarantia(String nombre, double precio, int stock, ProductoCategoria categoria, LocalDate garantia, boolean garantiaVencida){
        super(nombre, categoria, precio, stock);
        this.garantia = garantia;
        this.garantiaVencida = garantiaVencida;
    }

    public void garantiaVencidaLog(){
        if (garantia.isEqual(fechaActual) || garantia.isBefore(fechaActual)){
            garantiaVencida = true;
        }else{
            garantiaVencida = false;
        }
    }

    @Override
    public void mostrarInfo(){
        garantiaVencidaLog();
        super.mostrarInfo();
        System.out.println("Garantia hasta: " + garantia);
        System.out.println("¿Garantia vencida?: " + garantiaVencida);
    }

    public LocalDate getGarantia(){
        return garantia;
    }

    public void setGarantia(LocalDate garantia){
        this.garantia = garantia;
    }

    public boolean garantiaVencida(){
        return garantiaVencida;
    }
    
    public void setGarantiaVencida(boolean garantiaVencida){
        this.garantiaVencida = garantiaVencida;
    }


}
