package cl.duoc.ticketpro.model;

public class Vip extends Entrada{
    private double descuento;

    public Vip() {
    }

    public Vip(int codigo, String nombreEvento, double precio, double descuento) {
        super(codigo, nombreEvento, precio);
        setDescuento(descuento);
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        if(descuento<0 || descuento>100){
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100%");
        }
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return super.toString() + "Vip{" +
                "descuento=" + descuento +
                '}';
    }

    @Override
    public double calcularPrecioFinal() {
        return super.precio - super.precio*this.descuento;
    }

    @Override
    public String generarDetalle() {
        return "("+super.codigo + ") " + super.nombreEvento + " - $" + calcularPrecioFinal() + " (descuento: $" + super.precio*this.descuento + ")";
    }
}
