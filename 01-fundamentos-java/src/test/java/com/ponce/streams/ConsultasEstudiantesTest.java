package com.ponce.streams;

import com.ponce.poo.EstudianteGrado;
import com.ponce.poo.EstudiantePosgrado;
import com.ponce.poo.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ConsultasEstudiantesTest {

    private List<Estudiante> estudiantes;

    @BeforeEach
    void setUp() {
        EstudianteGrado e1 = new EstudianteGrado("Carlos", "G001", "Sistemas");
        e1.agregarNota(8.0);
        e1.agregarNota(9.0); // promedio 8.5 → aprobó

        EstudianteGrado e2 = new EstudianteGrado("Beatriz", "G002", "Sistemas");
        e2.agregarNota(4.0);
        e2.agregarNota(5.0); // promedio 4.5 → reprobó

        EstudiantePosgrado e3 = new EstudiantePosgrado("Ana", "P001", "Maestría");
        e3.agregarNota(10.0);
        e3.agregarNota(9.0); // promedio 9.5 → aprobó

        estudiantes = List.of(e1, e2, e3);
    }

    @Test
    void testFiltrarAprobados() {
        List<Estudiante> aprobados = ConsultasEstudiantes.filtrarAprobados(estudiantes);
        assertEquals(2, aprobados.size());
        assertTrue(aprobados.stream().allMatch(Estudiante::aprobo));
    }

    @Test
    void testNombresOrdenados() {
        List<String> nombres = ConsultasEstudiantes.nombresOrdenados(estudiantes);
        assertEquals(List.of("Ana", "Beatriz", "Carlos"), nombres);
    }

    @Test
    void testMejorEstudiante() {
        Optional<Estudiante> mejor = ConsultasEstudiantes.mejorEstudiante(estudiantes);
        assertTrue(mejor.isPresent());
        assertEquals("Ana", mejor.get().getNombre());
    }

    @Test
    void testMejorEstudianteListaVacia() {
        Optional<Estudiante> mejor = ConsultasEstudiantes.mejorEstudiante(List.of());
        assertFalse(mejor.isPresent());
    }

    @Test
    void testPromedioGeneral() {
        // (8.5 + 4.5 + 9.5) / 3 = 7.5
        assertEquals(7.5, ConsultasEstudiantes.promedioGeneral(estudiantes), 0.001);
    }

    @Test
    void testPromedioGeneralListaVacia() {
        assertEquals(0.0, ConsultasEstudiantes.promedioGeneral(List.of()), 0.001);
    }

    @Test
    void testAgruparPorTipo() {
        Map<String, List<Estudiante>> grupos = ConsultasEstudiantes.agruparPorTipo(estudiantes);
        assertTrue(grupos.containsKey("Grado"));
        assertTrue(grupos.containsKey("Posgrado"));
        assertEquals(2, grupos.get("Grado").size());
        assertEquals(1, grupos.get("Posgrado").size());
    }
}
