package com.ponce.colecciones;

import com.ponce.excepciones.EstudianteNoEncontradoException;
import com.ponce.excepciones.MatriculaDuplicadaException;
import com.ponce.poo.Estudiante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Gestor de estudiantes que demuestra el uso de colecciones (List y Map) en Java.
 * Combina List para mantener el orden de inserción y Map para búsqueda rápida por matrícula.
 */
public class GestorEstudiantes {

    private final List<Estudiante> listaEstudiantes;
    private final Map<String, Estudiante> mapaPorMatricula;

    public GestorEstudiantes() {
        this.listaEstudiantes = new ArrayList<>();
        this.mapaPorMatricula = new HashMap<>();
    }

    /**
     * Registra un nuevo estudiante en el sistema.
     *
     * @throws MatriculaDuplicadaException si ya existe un estudiante con esa matrícula.
     */
    public void registrar(Estudiante estudiante) {
        if (mapaPorMatricula.containsKey(estudiante.getMatricula())) {
            throw new MatriculaDuplicadaException(estudiante.getMatricula());
        }
        listaEstudiantes.add(estudiante);
        mapaPorMatricula.put(estudiante.getMatricula(), estudiante);
    }

    /**
     * Busca un estudiante por su matrícula.
     *
     * @throws EstudianteNoEncontradoException si no existe ningún estudiante con esa matrícula.
     */
    public Estudiante buscarPorMatricula(String matricula) throws EstudianteNoEncontradoException {
        return Optional.ofNullable(mapaPorMatricula.get(matricula))
                .orElseThrow(() -> new EstudianteNoEncontradoException(matricula));
    }

    /**
     * Elimina un estudiante por su matrícula.
     *
     * @throws EstudianteNoEncontradoException si no existe ningún estudiante con esa matrícula.
     */
    public void eliminar(String matricula) throws EstudianteNoEncontradoException {
        Estudiante estudiante = buscarPorMatricula(matricula);
        listaEstudiantes.remove(estudiante);
        mapaPorMatricula.remove(matricula);
    }

    /** Retorna una vista no modificable de la lista de estudiantes registrados. */
    public List<Estudiante> getTodos() {
        return Collections.unmodifiableList(listaEstudiantes);
    }

    /** Retorna el total de estudiantes registrados. */
    public int getTotalEstudiantes() {
        return listaEstudiantes.size();
    }
}
