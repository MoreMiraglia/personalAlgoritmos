package practicaParcial2.src

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private int cantFans;
    private int puntosTotales;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesAFavor;
    private int golesEnContra;

    public Equipo(String nombre, int cantFans) {
        this.nombre = nombre;
        this.cantFans = cantFans;
        this.puntosTotales = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public int getDiferenciaGol() {
        return golesAFavor - golesEnContra;
    }

    public void actualizarEstadisticas(int golesFavor, int golesContra) {
        partidosJugados++;
        golesAFavor += golesFavor;
        golesEnContra += golesContra;

        if (golesFavor > golesContra) {
            partidosGanados++;
            puntosTotales += 3;
        } else if (golesFavor == golesContra) {
            partidosEmpatados++;
            puntosTotales += 1;
        } else {
            partidosPerdidos++;
        }
    }
}
