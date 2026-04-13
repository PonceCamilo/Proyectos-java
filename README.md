# Proyectos Java

Repositorio de proyectos personales en Java para profundizar en el lenguaje y construir un portafolio profesional.

## Estructura

| Módulo | Descripción |
|---|---|
| [`01-fundamentos-java`](./01-fundamentos-java) | POO, colecciones, excepciones personalizadas y Streams |

## Módulo 01 — Fundamentos Java

### Conceptos cubiertos

- **Programación Orientada a Objetos (POO)**
  - Interfaces (`Calificable`)
  - Clases abstractas (`Estudiante`)
  - Herencia y polimorfismo (`EstudianteGrado`, `EstudiantePosgrado`)
  - Encapsulamiento (atributos privados, getters, validaciones)

- **Colecciones**
  - `List<T>` (ArrayList) para mantener el orden de inserción
  - `Map<K,V>` (HashMap) para búsqueda rápida por matrícula
  - Vistas no modificables con `Collections.unmodifiableList`

- **Excepciones personalizadas**
  - `EstudianteNoEncontradoException` (checked)
  - `MatriculaDuplicadaException` (unchecked / RuntimeException)

- **Stream API (Java 8+)**
  - `filter`, `map`, `sorted`, `max`, `average`, `groupingBy`

### Requisitos

- Java 17+
- Maven 3.6+

### Compilar y ejecutar

```bash
cd 01-fundamentos-java
mvn package -DskipTests
java -cp target/01-fundamentos-java-1.0-SNAPSHOT.jar com.ponce.Main
```

### Ejecutar tests

```bash
cd 01-fundamentos-java
mvn test
```

Resultado esperado: **25 tests, 0 fallos**.
