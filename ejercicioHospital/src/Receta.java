import java.util.ArrayList;
import java.util.List;

public class Receta {
    private int id;
    private Profesional profesional;
    private Paciente paciente;
    private List<Estudio> estudios;
    private String estado;

    public Receta (int id, Profesional profesional, Paciente paciente, Estudio[] estudio){
        this.id = id;
        this.profesional = profesional;
        this.paciente = paciente; 
        this.estudios = new ArrayList<>();
        estudios.add(estudio[i]);
        this.estado = "Pendiente";

    }

    public boolean estaProcesada(){
        if (estado.equals("Pendiente")){
            return false;
        }
        else{
            return true;
        }
    }

    public void procesar(){
        this.estado = "Procesada";
        for (Estudio estudio : estudios){
            System.out.println("Notificando a paciente" + paciente + "sobre " + estudio);
            System.out.println("Notificando a profesional" + paciente + "sobre " + estudio);
            estudio.setEstado();
            paciente.agregarEstudioRealizado();
        }
    }

    public void mostrarInformacion() {
        System.out.println("Receta" + id);
        System.out.println(profesional);
        System.out.println(paciente);
        System.out.println(estado);
        for (Estudio estudio : estudios){
            System.out.println(estudio);
        }
        
    }




}
