package com.ponce.excepciones;

/**
 * Excepción lanzada cuando no se encuentra un estudiante en el sistema.
 * Demuestra la creación de excepciones personalizadas (checked exception).
 */
public class EstudianteNoEncontradoException extends Exception {

    private final String matricula;

    public EstudianteNoEncontradoException(String matricula) {
        super("No se encontró ningún estudiante con matrícula: " + matricula);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
