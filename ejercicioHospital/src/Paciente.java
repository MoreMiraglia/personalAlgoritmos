import java.util.ArrayList;

public class Paciente {
    private int dni;
    private String nombre;
    private int estudiosRealizados;


    public Paciente (String nombre, int dni){
        this.nombre = nombre;
        this.dni = dni;
        this.estudiosRealizados = 0;

    }

    public void agregarEstudioRealizado(){
        this.estudiosRealizados += 1;
    }
    

    public int getDni() {
        return dni;
    }
    
    @Override
    public String toString() {
        return "Paciente:" + nombre + "[" + dni + "]";
    }

    public int getEstudiosRealizados() {
        return estudiosRealizados;
    }



}
