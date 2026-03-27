package com.ponce.poo;

/**
 * Interfaz que define el comportamiento de un objeto calificable.
 * Demuestra el uso de interfaces en Java.
 */
public interface Calificable {

    /** Retorna el promedio de notas del estudiante. */
    double calcularPromedio();

    /** Retorna true si el estudiante aprobó (promedio >= 6.0). */
    default boolean aprobo() {
        return calcularPromedio() >= 6.0;
    }
}
