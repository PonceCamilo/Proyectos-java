package com.ponce.excepciones;

/**
 * Excepción lanzada cuando se intenta registrar un estudiante con
 * una matrícula que ya existe en el sistema.
 * Demuestra excepciones personalizadas (unchecked/runtime exception).
 */
public class MatriculaDuplicadaException extends RuntimeException {

    private final String matricula;

    public MatriculaDuplicadaException(String matricula) {
        super("Ya existe un estudiante con la matrícula: " + matricula);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}
