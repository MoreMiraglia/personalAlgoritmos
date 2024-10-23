package practicaParcial.src
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int capacidad;
    private int numero; 
    private List<Reserva> reservas;

    public Habitacion (int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.reservas = new ArrayList<>();
    }

    public int getNumero(){
        return this.numero;
    }

    public int getCapacidad(){
        return this.capacidad;
    }

    public boolean estaDisponible(LocalDate checkin, LocalDate checkout) {
        for (Reserva reserva : reservas) {
            // Si hay una superposición en las fechas, la habitación no está disponible
            if (!(checkout.isBefore(reserva.getCheckin()) || checkin.isAfter(reserva.getCheckout()))) {
                return false;  // No está disponible
            }
        }
        return true;  // Está disponible si no hay reservas que se superpongan
    }
    
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
}

        

    


    

