package camilo.ponce;

public class EmpleadoFijo extends Empleado{
  private final double sueldoBase;

  public EmpleadoFijo(String nombre, int legajo, double sueldoBase) {
    super(nombre, legajo);
    this.sueldoBase = sueldoBase;
  }

  @Override
  public double calcularSueldo() {
    return sueldoBase;
  }
}
