package practicaParcial.src
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String direccion;
    private double precioNoche;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel(String nombre, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>(); 
    }    

    public String getNombre(){
        return nombre;
    }

    public void agregarHabitacion(int capacidad){
        Habitacion habitacion = new Habitacion(habitaciones.size() + 1, capacidad);
        habitaciones.add(habitacion);
    }

    public void definirPrecioNoche(double precioNoche){
        this.precioNoche = precioNoche; 
    }

    public void consultarDisponibilidad(LocalDate checkin, LocalDate checkout){
        System.out.println("Habitaciones disponibles entre " + checkin + " y " + checkout + ":");
        for(Habitacion habitacion : habitaciones){
            if (habitacion.estaDisponible(checkin, checkout)){
                System.out.println("Habitación " + habitacion.getNumero() + " con capacidad de " + habitacion.getCapacidad() + " personas.");
            }
        }
    }

    public void reservarHabitacion(Cliente cliente, LocalDate checkin, LocalDate checkout, int cantPersonas){
        for (Habitacion habitacion : habitaciones){
            if (habitacion.estaDisponible(checkin, checkout) && cantPersonas <= habitacion.getCapacidad()){
                Reserva reserva = new Reserva(reservas.size() + 1, cliente, habitacion, checkin, checkout, precioNoche);
                reservas.add(reserva);
                habitacion.agregarReserva(reserva);  // Agregamos la reserva a la habitación
                System.out.println("Habitación reservada");
                return;
            }
        }
        System.out.println("No hay habitaciones disponibles para esa capacidad y fechas.");
    }

    public void mostrarReservasHotel(){
        if (reservas.size() != 0){
            System.out.println("Reservas del " + this.nombre + ":");
            for (Reserva reserva : reservas){
                reserva.mostrarInformacion();
            }
        } else {
            System.out.println("El " + this.nombre + " no tiene reservas por el momento.");
        }
    }
}

