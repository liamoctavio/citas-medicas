package citasmedicas.example.citas;


// Clase representativa de una cita
public class Citas {

    //Atributos de la clase
    private Long id;
    private String nombrePaciente;
    private String fechaCita;

    // Constructor de la clase
    public Citas(Long id, String nombrePaciente, String fechaCita) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.fechaCita = fechaCita;

    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }


}
