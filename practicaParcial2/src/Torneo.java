package practicaParcial2.src

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Torneo {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Torneo() {
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void cargarEquipo(String nombre, int cantFans) {
        Equipo equipo = new Equipo(nombre, cantFans);
        equipos.add(equipo);
    }

    public void cargarPartido(String nombreEquipo1, String nombreEquipo2, LocalDate fecha, int golesEquipo1, int golesEquipo2) {
        Equipo equipo1 = null;
        Equipo equipo2 = null;
        for (Equipo equipo : equipos){
            if (equipo.getNombre().equals(nombreEquipo1)){
                equipo1 = equipo;
            }
            if (equipo.getNombre().equals(nombreEquipo2)){
                equipo2 = equipo;
            }
        }
        if (equipo1 == null) {
            System.out.println("El equipo '" + nombreEquipo1 + "' no existe en este torneo.");
        }
        if (equipo2 == null) {
            System.out.println("El equipo '" + nombreEquipo2 + "' no existe en este torneo.");
        }
        
        Partido partido = new Partido(equipo1, equipo2, fecha, golesEquipo1, golesEquipo2);
        partidos.add(partido);
    }

    public void mostrarPartidosFecha(LocalDate fecha) {
        int cantPartidos = 0;
        for (Partido partido : partidos) {
            if (partido.getFecha().equals(fecha)) {
                partido.mostrarInformacion();
                cantPartidos++;
            }
        }
        if (cantPartidos == 0) {
            System.out.println("No hay partidos agendados para esa fecha.");
        }
    }

    public void mostrarTabla() {
        equipos.sort(Comparator.comparing(Equipo::getPuntosTotales)
                .thenComparing(Equipo::getGolesAFavor)
                .reversed());

        System.out.println("Tabla de posiciones:");
        System.out.println("Equipo" + "PJ" + "PTS" + "G" + "E" + "P" + "GF" + "GC" + "DG");

        for (Equipo equipo : equipos) {
            System.out.printf("%-15s %-10d %-10d %-10d %-10d %-10d %-10d %-10d %-10d\n",
                    equipo.getNombre(),
                    equipo.getPartidosJugados(),
                    equipo.getPuntosTotales(),
                    equipo.getPartidosGanados(),
                    equipo.getPartidosEmpatados(),
                    equipo.getPartidosPerdidos(),
                    equipo.getGolesAFavor(),
                    equipo.getGolesEnContra(),
                    equipo.getDiferenciaGol());
        }
    }
}
