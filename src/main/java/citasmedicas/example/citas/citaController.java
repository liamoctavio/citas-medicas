package citasmedicas.example.citas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
public class citaController {

    // Lista para almacenar las citas
    private List<Citas> citas = new ArrayList<>();
    
    // Constructor que inicializa algunas citas de ejemplo
    public citaController() {
        citas.add(new Citas(1L, "Juan", "2021-10-10"));
        citas.add(new Citas(2L, "Maria", "2021-10-11"));
        citas.add(new Citas(3L, "Pedro", "2021-10-12"));
    }


    // Endpoint para listar todas las citas
    @RequestMapping("/listar")
    public List<Citas> listar() {
        return citas;
    }
    // Endpoint para buscar una cita por su ID
    @GetMapping("/buscar/{id}")
    public Citas buscarPorId(@PathVariable int id) {
        // Busca la cita en la lista de citas por ID
        Optional<Citas> cita = citas.stream().filter(e -> e.getId() == id).findFirst();
        // Devuelve la cita encontrada o null si no se encuentra
        return cita.orElse(null);
    }

    @GetMapping("/disponibilidad")
    public List<String> verDisponibilidad() {
        // Genera la lista de horarios disponibles
        List<String> horarios = generarHorarios();
        // Obtiene los horarios ocupados de las citas existentes
        List<String> horariosOcupados = citas.stream()
                .map(Citas::getFechaCita)
                .collect(Collectors.toList());
        
        // Filtra los horarios disponibles eliminando los horarios ocupados
        return horarios.stream()
                .filter(horario -> !horariosOcupados.contains(horario))
                .collect(Collectors.toList());
    }

    private List<String> generarHorarios() {
        List<String> horarios = new ArrayList<>();
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 0);

        // Genera horarios desde las 9:00 AM hasta las 5:00 PM con intervalos de una hora
        while (!start.equals(end)) {
            horarios.add(start.toString());
            start = start.plusHours(1);
        }
        return horarios;
    }




    






}
