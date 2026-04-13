package com.ponce.poo;

/**
 * Estudiante de posgrado.
 * Demuestra herencia concreta y polimorfismo.
 */
public class EstudiantePosgrado extends Estudiante {

    private final String programa;
    private String director;

    public EstudiantePosgrado(String nombre, String matricula, String programa) {
        super(nombre, matricula);
        if (programa == null || programa.isBlank()) {
            throw new IllegalArgumentException("El programa no puede ser vacío.");
        }
        this.programa = programa;
    }

    public String getPrograma() {
        return programa;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getTipo() {
        return "Posgrado";
    }

    @Override
    public String toString() {
        String info = super.toString() + " | programa: " + programa;
        if (director != null) {
            info += " | director: " + director;
        }
        return info;
    }
}
