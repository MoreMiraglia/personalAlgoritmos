import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    private List<Profesional> profesionales;
    private List<Paciente> pacientes; 
    private List<Receta> recetas;


    public Hospital(String nombre) {
        this.nombre = nombre; 
        this.profesionales = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.recetas = new ArrayList<>();
    
    }

    public void registrarProfesional(String nombre, int matricula) {
        boolean existe = false;
        for (Profesional profesional : profesionales){
            if (profesional.getMatricula() == matricula){
                System.out.println("Este profesional ya está registrado");
                existe = true; 
            }
        }
        if (existe == false){
            Profesional profesional = new Profesional (nombre, matricula);
            profesionales.add(profesional);
        }

    }

    public void registrarPaciente(String nombre, int dni) {
        boolean existe = false;
        for (Paciente paciente : pacientes){
            if (paciente.getDni() == dni){
                System.out.println("Este paciente ya está registrado");
                existe = true; 
            }
        }
        if (existe == false){
            Paciente paciente = new Paciente (nombre, dni);
            pacientes.add(paciente);
        }

    }

    public Receta cargarReceta(String nombreProfesional, String nombrePaciente, Estudio[] estudios) {
        Profesional profesional = null;
        Paciente paciente = null;
    
        // Buscar el profesional por nombre
        for (Profesional p : profesionales) {
            if (p.toString().contains(nombreProfesional)) {  // Comprobamos si el nombre está en la representación de texto
                profesional = p;
                break;
            }
        }
    
        // Buscar el paciente por nombre
        for (Paciente p : pacientes) {
            if (p.toString().contains(nombrePaciente)) {  // Comprobamos si el nombre está en la representación de texto
                paciente = p;
                break;
            }
        }
    
        // Verificar que tanto el profesional como el paciente existan
        if (profesional != null && paciente != null) {
            int idReceta = recetas.size() + 1;
            Receta receta = new Receta(idReceta, profesional, paciente, estudios);
            recetas.add(receta);
            return receta;  
        } else {
            System.out.println("La receta no pudo ser cargada. Pruebe registrando al profesional y/o paciente");
            return null; 
        }
    }
    

    public void procesar(Receta receta) {
        if (receta.estaProcesada() == true){
            System.out.println("La receta ya fue procesada anteriormente.");
        }
        else{
            receta.procesar();
        }  
    }

    public void mostrarRecetas() {
        System.out.println("Recetas de" + nombre);
        for (Receta receta : recetas){
            receta.mostrarInformacion();

        }
    }

    public void mostrarRecetasProcesadas() {
        int procesadas = 0;
        for (Receta receta : recetas) {
            if (receta.estaProcesada() == true){
                receta.mostrarInformacion();
                procesadas += 1;
            }
        }
        if (procesadas == 0){
            System.out.println("No hay recetas procesadas aún en el hospital");
        }
    }

    public void mostrarPacientesConEstudios(int minEstudios) {
        int cantidad = 0;
        for (Paciente paciente : pacientes){
            if (paciente.getEstudiosRealizados() >= minEstudios){
                System.out.println(paciente);
                cantidad += 1;

            }
        }
        if (cantidad == 0){
            System.out.println("No existen pacientes con" + minEstudios + "o más estudios realizados en este hospital");
        }
    }
    
}
