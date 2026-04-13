package com.ponce.poo;

/**
 * Estudiante de grado (licenciatura).
 * Demuestra herencia concreta y polimorfismo.
 */
public class EstudianteGrado extends Estudiante {

    private final String carrera;

    public EstudianteGrado(String nombre, String matricula, String carrera) {
        super(nombre, matricula);
        if (carrera == null || carrera.isBlank()) {
            throw new IllegalArgumentException("La carrera no puede ser vacía.");
        }
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String getTipo() {
        return "Grado";
    }

    @Override
    public String toString() {
        return super.toString() + " | carrera: " + carrera;
    }
}
