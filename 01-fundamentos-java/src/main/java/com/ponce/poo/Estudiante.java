package com.ponce.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase abstracta que representa un estudiante genérico.
 * Demuestra herencia, encapsulamiento y clases abstractas en Java.
 */
public abstract class Estudiante implements Calificable {

    private final String nombre;
    private final String matricula;
    private final List<Double> notas;

    protected Estudiante(String nombre, String matricula) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío.");
        }
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("La matrícula no puede ser vacía.");
        }
        this.nombre = nombre;
        this.matricula = matricula;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Double> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    public void agregarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10. Nota recibida: " + nota);
        }
        notas.add(nota);
    }

    @Override
    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    /** Método abstracto que cada tipo de estudiante debe implementar. */
    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] %s (matrícula: %s) | promedio: %.2f | aprobó: %s",
                getTipo(), nombre, matricula, calcularPromedio(), aprobo() ? "Sí" : "No");
    }
}
