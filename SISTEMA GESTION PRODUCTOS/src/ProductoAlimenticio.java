import java.time.LocalDate;

public class ProductoAlimenticio extends Producto{
    
    private LocalDate vencimiento;
    private boolean estaVencido;
    private LocalDate fechaActual = LocalDate.now();


    public ProductoAlimenticio(String nombre, double precio, int stock, ProductoCategoria categoria, LocalDate vencimiento, boolean estaVencido){
        super(nombre, categoria, precio, stock);
        this.vencimiento = vencimiento;
        this.estaVencido = estaVencido;
    }

    public void estaVencidoLog(){
        if (vencimiento.isEqual(fechaActual) || vencimiento.isBefore(fechaActual)){
            estaVencido = true;
        }else{
            estaVencido = false;
        }
    }

    @Override
    public void mostrarInfo(){
        estaVencidoLog();
        super.mostrarInfo();
        System.out.println("Vencimiento: " + vencimiento);
        System.out.println("¿Esta vencido?: " + estaVencido);
    }


    public LocalDate getVencimiento(){
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento){
        this.vencimiento = vencimiento;
    }

    public boolean getEstaVencido(){
        return estaVencido;
    }

    public void setEstaVencido(boolean estaVencido){
        this.estaVencido = estaVencido;
    }


}


