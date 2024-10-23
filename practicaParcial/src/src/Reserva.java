package practicaParcial.src
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class Reserva {
    private Cliente cliente;
    private LocalDate checkin;
    private LocalDate checkout;
    private int numeroReserva;
    private Habitacion habitacion;
    private double monto;
    private long cantNoches;

    public Reserva (int numeroReserva, Cliente cliente, Habitacion habitacion, LocalDate checkin, LocalDate checkout, double precioNoche) {
        this.numeroReserva = numeroReserva;
        this.checkin = checkin;
        this.checkout = checkout;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.cantNoches =  ChronoUnit.DAYS.between(checkin, checkout);
        this.monto = calcularPrecio(precioNoche, cantNoches);
    }

    public double calcularPrecio(double precioNoche, long cantNoches){
        
        return cantNoches * precioNoche;

    }
    
    public LocalDate getCheckin(){
        return checkin;
    }

    public LocalDate getCheckout(){
        return checkout;
    }
    
    public void mostrarInformacion(){
        System.out.println("Reserva" + this.numeroReserva);
        System.out.println("- Habitacion: " + habitacion.getNumero() + ", capacidad=" + habitacion.getCapacidad() + " pax.");
        System.out.println("- Cliente: " + cliente.getNombre()); 
        System.out.println("- Checkin: " + checkin);
        System.out.println("- Checkout: " + checkout);
        System.out.println("- Cantidad de noches: " + cantNoches);
        System.out.println("- Monto: $" + monto);
        
    }
}
