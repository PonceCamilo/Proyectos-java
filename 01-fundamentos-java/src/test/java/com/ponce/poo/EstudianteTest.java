package com.ponce.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    private EstudianteGrado estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new EstudianteGrado("Ana García", "G001", "Ingeniería en Sistemas");
    }

    @Test
    void testNombreYMatriculaInicializados() {
        assertEquals("Ana García", estudiante.getNombre());
        assertEquals("G001", estudiante.getMatricula());
        assertEquals("Ingeniería en Sistemas", estudiante.getCarrera());
    }

    @Test
    void testPromedioConNotas() {
        estudiante.agregarNota(8.0);
        estudiante.agregarNota(6.0);
        assertEquals(7.0, estudiante.calcularPromedio(), 0.001);
    }

    @Test
    void testPromedioSinNotasEsCero() {
        assertEquals(0.0, estudiante.calcularPromedio(), 0.001);
    }

    @Test
    void testAproboConPromedioAlto() {
        estudiante.agregarNota(7.0);
        estudiante.agregarNota(8.0);
        assertTrue(estudiante.aprobo());
    }

    @Test
    void testNoAproboConPromedioBajo() {
        estudiante.agregarNota(4.0);
        estudiante.agregarNota(5.0);
        assertFalse(estudiante.aprobo());
    }

    @Test
    void testAgregarNotaFueraDeRangoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> estudiante.agregarNota(11.0));
        assertThrows(IllegalArgumentException.class, () -> estudiante.agregarNota(-1.0));
    }

    @Test
    void testNombreVacioLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> new EstudianteGrado("", "G002", "Ingeniería"));
    }

    @Test
    void testMatriculaVaciaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> new EstudianteGrado("Carlos", "", "Ingeniería"));
    }

    @Test
    void testGetTipoGrado() {
        assertEquals("Grado", estudiante.getTipo());
    }

    @Test
    void testGetTipoPosgrado() {
        EstudiantePosgrado posgrado = new EstudiantePosgrado("Marta", "P001", "Maestría en IA");
        assertEquals("Posgrado", posgrado.getTipo());
    }

    @Test
    void testListaNotasEsInmodificable() {
        estudiante.agregarNota(7.0);
        assertThrows(UnsupportedOperationException.class,
                () -> estudiante.getNotas().add(9.0));
    }
}
