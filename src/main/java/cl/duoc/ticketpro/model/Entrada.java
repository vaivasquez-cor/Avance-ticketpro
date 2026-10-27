package cl.duoc.ticketpro.model;

public abstract class Entrada implements Imprimible{
    protected int codigo;
    protected String nombreEvento;
    protected double precio;

    public Entrada() {
    }

    public Entrada(int codigo, String nombreEvento, double precio) {
        setCodigo(codigo);
        setNombreEvento(nombreEvento);
        setPrecio(precio);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if(codigo<=0){
            throw new IllegalArgumentException("El código debe ser positivo.");
        }
        this.codigo = codigo;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        if(nombreEvento==null || nombreEvento.isBlank()){
            throw new IllegalArgumentException("EL nombren no puede estar nulo o vacío.");
        }
        this.nombreEvento = nombreEvento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio<0){
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "codigo=" + codigo +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", precio=" + precio +
                '}';
    }

    public abstract double calcularPrecioFinal();

}
