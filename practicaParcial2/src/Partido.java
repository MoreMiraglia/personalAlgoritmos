package practicaParcial2.src
import java.time.LocalDate;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private LocalDate fecha;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(Equipo equipo1, Equipo equipo2, LocalDate fecha, int golesEquipo1, int golesEquipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;

        equipo1.actualizarEstadisticas(golesEquipo1, golesEquipo2);
        equipo2.actualizarEstadisticas(golesEquipo2, golesEquipo1);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void mostrarInformacion() {
        System.out.println(fecha + " - " + equipo1.getNombre() + " " + golesEquipo1 + " : " + golesEquipo2 + " " + equipo2.getNombre());
    }
}
