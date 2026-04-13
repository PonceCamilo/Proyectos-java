package com.ponce.colecciones;

import com.ponce.excepciones.EstudianteNoEncontradoException;
import com.ponce.excepciones.MatriculaDuplicadaException;
import com.ponce.poo.EstudianteGrado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorEstudiantesTest {

    private GestorEstudiantes gestor;
    private EstudianteGrado e1;
    private EstudianteGrado e2;

    @BeforeEach
    void setUp() {
        gestor = new GestorEstudiantes();
        e1 = new EstudianteGrado("Ana García", "G001", "Sistemas");
        e2 = new EstudianteGrado("Luis Pérez", "G002", "Sistemas");
    }

    @Test
    void testRegistrarYContarEstudiantes() {
        gestor.registrar(e1);
        gestor.registrar(e2);
        assertEquals(2, gestor.getTotalEstudiantes());
    }

    @Test
    void testBuscarPorMatriculaExistente() throws EstudianteNoEncontradoException {
        gestor.registrar(e1);
        assertEquals(e1, gestor.buscarPorMatricula("G001"));
    }

    @Test
    void testBuscarPorMatriculaInexistenteLanzaExcepcion() {
        EstudianteNoEncontradoException ex = assertThrows(
                EstudianteNoEncontradoException.class,
                () -> gestor.buscarPorMatricula("X999")
        );
        assertEquals("X999", ex.getMatricula());
    }

    @Test
    void testRegistrarMatriculaDuplicadaLanzaExcepcion() {
        gestor.registrar(e1);
        EstudianteGrado duplicado = new EstudianteGrado("Otro Nombre", "G001", "Sistemas");
        MatriculaDuplicadaException ex = assertThrows(
                MatriculaDuplicadaException.class,
                () -> gestor.registrar(duplicado)
        );
        assertEquals("G001", ex.getMatricula());
    }

    @Test
    void testEliminarEstudianteExistente() throws EstudianteNoEncontradoException {
        gestor.registrar(e1);
        gestor.registrar(e2);
        gestor.eliminar("G001");
        assertEquals(1, gestor.getTotalEstudiantes());
        assertThrows(EstudianteNoEncontradoException.class,
                () -> gestor.buscarPorMatricula("G001"));
    }

    @Test
    void testEliminarEstudianteInexistenteLanzaExcepcion() {
        assertThrows(EstudianteNoEncontradoException.class,
                () -> gestor.eliminar("X999"));
    }

    @Test
    void testGetTodosRetornaListaInmodificable() {
        gestor.registrar(e1);
        assertThrows(UnsupportedOperationException.class,
                () -> gestor.getTodos().add(e2));
    }
}
