package camilo.ponce;

public abstract class Empleado implements Imprimible {
  private final String nombre;
  private final int legajo;

  public Empleado(String nombre, int legajo) {
    this.nombre = nombre;
    this.legajo = legajo;
  }

  public abstract double calcularSueldo();

  @Override
  public void imprimir() {
    System.out.println("Nombre: " + nombre);
    System.out.println("Legajo: " + legajo);
    System.out.println("Sueldo: " + calcularSueldo());
  }

  @Override
  public String toString() {
    return "Empleado{" + "nombre='" + nombre + '\'' + ", legajo=" + legajo + '}';
  }
}
