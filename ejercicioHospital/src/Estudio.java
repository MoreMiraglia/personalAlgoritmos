
public abstract class Estudio {
    private String nombre;
    private String descripcion;
    private String estado;

    public Estudio(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = "No Realizado"; 
    }

    public void setEstado(){
        this.estado = "Realizado";
    }

    @Override
    public String toString() {
        return nombre + descripcion + "(" + estado + ")" ;
    }

}
