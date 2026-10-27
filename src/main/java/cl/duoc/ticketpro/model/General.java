package cl.duoc.ticketpro.model;

public class General extends Entrada{
    private int numeroAsiento;

    public General() {
    }

    public General(int codigo, String nombreEvento, double precio, int numeroAsiento) {
        super(codigo, nombreEvento, precio);
        setNumeroAsiento(numeroAsiento);
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        if(numeroAsiento<=0){
            throw new IllegalArgumentException("El número del asiento debe ser positivo.");
        }
        this.numeroAsiento = numeroAsiento;
    }

    @Override
    public String toString() {
        return super.toString() + "General{" +
                "numeroAsiento=" + numeroAsiento +
                '}';
    }

    @Override
    public double calcularPrecioFinal() {
        return super.precio;
    }

    @Override
    public String generarDetalle() {
        return "("+super.codigo + ") " + super.nombreEvento + " - $" + calcularPrecioFinal() + " (Asiento: " + this.numeroAsiento + ")";
    }
}
