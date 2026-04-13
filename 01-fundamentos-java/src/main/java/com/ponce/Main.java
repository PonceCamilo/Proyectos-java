package com.ponce;

import com.ponce.colecciones.GestorEstudiantes;
import com.ponce.excepciones.EstudianteNoEncontradoException;
import com.ponce.poo.EstudianteGrado;
import com.ponce.poo.EstudiantePosgrado;
import com.ponce.streams.ConsultasEstudiantes;

import java.util.List;

/**
 * Punto de entrada principal del módulo de fundamentos Java.
 * Ejecuta una demostración de los conceptos estudiados:
 * POO, colecciones, excepciones personalizadas y Streams.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Fundamentos Java - Sistema de Estudiantes ===\n");

        // --- POO: instanciación de objetos ---
        EstudianteGrado e1 = new EstudianteGrado("Ana García", "G001", "Ingeniería en Sistemas");
        e1.agregarNota(8.5);
        e1.agregarNota(7.0);
        e1.agregarNota(9.0);

        EstudianteGrado e2 = new EstudianteGrado("Luis Pérez", "G002", "Ingeniería en Sistemas");
        e2.agregarNota(5.0);
        e2.agregarNota(4.5);
        e2.agregarNota(6.0);

        EstudiantePosgrado e3 = new EstudiantePosgrado("Marta López", "P001", "Maestría en IA");
        e3.setDirector("Dr. Carlos Ruiz");
        e3.agregarNota(9.5);
        e3.agregarNota(8.0);

        EstudiantePosgrado e4 = new EstudiantePosgrado("Jorge Díaz", "P002", "Maestría en IA");
        e4.agregarNota(5.5);
        e4.agregarNota(5.0);

        // --- Colecciones: registro en GestorEstudiantes ---
        GestorEstudiantes gestor = new GestorEstudiantes();
        gestor.registrar(e1);
        gestor.registrar(e2);
        gestor.registrar(e3);
        gestor.registrar(e4);

        System.out.println("--- Todos los estudiantes registrados ---");
        gestor.getTodos().forEach(System.out::println);

        // --- Excepciones: búsqueda con manejo de error ---
        System.out.println("\n--- Búsqueda por matrícula ---");
        try {
            System.out.println("Encontrado: " + gestor.buscarPorMatricula("G001"));
            System.out.println("Encontrado: " + gestor.buscarPorMatricula("X999")); // Esto lanza excepción
        } catch (EstudianteNoEncontradoException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // --- Streams: consultas funcionales ---
        List<com.ponce.poo.Estudiante> todos = gestor.getTodos();

        System.out.println("\n--- Estudiantes aprobados ---");
        ConsultasEstudiantes.filtrarAprobados(todos).forEach(e -> System.out.println("  " + e.getNombre()));

        System.out.println("\n--- Nombres en orden alfabético ---");
        ConsultasEstudiantes.nombresOrdenados(todos).forEach(n -> System.out.println("  " + n));

        System.out.println("\n--- Mejor estudiante ---");
        ConsultasEstudiantes.mejorEstudiante(todos)
                .ifPresent(e -> System.out.println("  " + e));

        System.out.printf("%n--- Promedio general: %.2f ---%n",
                ConsultasEstudiantes.promedioGeneral(todos));

        System.out.println("\n--- Estudiantes agrupados por tipo ---");
        ConsultasEstudiantes.agruparPorTipo(todos)
                .forEach((tipo, lista) -> {
                    System.out.println("  " + tipo + ":");
                    lista.forEach(e -> System.out.println("    - " + e.getNombre()));
                });

        System.out.println("\n=== Fin de la demostración ===");
    }
}
