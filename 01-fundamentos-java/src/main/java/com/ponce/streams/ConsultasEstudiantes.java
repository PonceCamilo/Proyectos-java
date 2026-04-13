package com.ponce.streams;

import com.ponce.poo.Estudiante;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase utilitaria que demuestra el uso de la Stream API de Java
 * para consultar y transformar colecciones de estudiantes.
 */
public class ConsultasEstudiantes {

    private ConsultasEstudiantes() {
        // Clase utilitaria, no instanciable.
    }

    /** Retorna solo los estudiantes que aprobaron. */
    public static List<Estudiante> filtrarAprobados(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .filter(Estudiante::aprobo)
                .collect(Collectors.toList());
    }

    /** Retorna los nombres de todos los estudiantes, en orden alfabético. */
    public static List<String> nombresOrdenados(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(Estudiante::getNombre)
                .sorted()
                .collect(Collectors.toList());
    }

    /** Retorna el estudiante con el mayor promedio, o vacío si la lista es vacía. */
    public static Optional<Estudiante> mejorEstudiante(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .max(Comparator.comparingDouble(Estudiante::calcularPromedio));
    }

    /** Calcula el promedio general de todos los estudiantes. */
    public static double promedioGeneral(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .mapToDouble(Estudiante::calcularPromedio)
                .average()
                .orElse(0.0);
    }

    /**
     * Agrupa estudiantes por tipo (Grado / Posgrado).
     * Retorna un Map donde la clave es el tipo y el valor es la lista de estudiantes.
     */
    public static Map<String, List<Estudiante>> agruparPorTipo(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .collect(Collectors.groupingBy(Estudiante::getTipo));
    }
}
