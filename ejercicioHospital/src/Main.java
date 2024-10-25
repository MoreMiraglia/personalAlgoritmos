public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Pura Salud");

        // Profesionales de salud
        hospital.registrarProfesional("Juana", 12345);
        hospital.registrarProfesional("Ana", 11234);
        hospital.registrarProfesional("Maria", 54321);

        // Pacientes
        hospital.registrarPaciente("Pedro", 35234111);
        hospital.registrarPaciente("Tomas", 34942999);
        hospital.registrarPaciente("Juan", 32912000);

        // Recetas
        Receta receta1 = hospital.cargarReceta("Juana", "Pedro", new Estudio[] {
            new EstudioRX("columna"),
            new EstudioRX("torax")
        });
        Receta receta2 = hospital.cargarReceta("Juana", "Tomas", new Estudio[] {
            new EstudioRX("abdomen"),
            new EstudioRX("torax")
        });
        Receta receta3 = hospital.cargarReceta("Ana", "Juan", new Estudio[] {
            new EstudioRX("abdomen"),
            new EstudioLaboratorio(5)
        });
        Receta receta4 = hospital.cargarReceta("Ana", "Pedro", new Estudio[] {
            new EstudioLaboratorio(15)
        });
        Receta receta5 = hospital.cargarReceta("Maria", "Juan", new Estudio[] {
            new EstudioRX("columna"),
            new EstudioRX("abdomen"),
            new EstudioLaboratorio(10)
        });

        // Procesamiento
        hospital.procesar(receta1);
        hospital.procesar(receta2);
        hospital.procesar(receta3);
        hospital.procesar(receta4);

        // Mostrar recetas
        hospital.mostrarRecetas();

        // Mostrar recetas procesadas
        hospital.mostrarRecetasProcesadas();

        // Mostrar pacientes con al menos 2 estudios realizados
        hospital.mostrarPacientesConEstudios(2);  // Ajuste en el número de estudios

    }
}
