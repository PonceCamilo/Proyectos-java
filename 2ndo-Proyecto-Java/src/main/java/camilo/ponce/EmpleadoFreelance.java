package camilo.ponce;

public class EmpleadoFreelance extends Empleado{
  private final int horasTrabajadas;
  private final double valorHora;

  public EmpleadoFreelance(String nombre, int legajo, double valorHora, int horasTrabajadas) {
    super(nombre, legajo);
    this.horasTrabajadas = horasTrabajadas;
    this.valorHora = valorHora;
  }

  @Override
  public double calcularSueldo() {
    return horasTrabajadas * valorHora;
  }

  @Override
  public String toString() {
    return "EmpleadoFreelance{" + super.toString() + ", horasTrabajadas=" + horasTrabajadas + ", valorHora=" + valorHora + "}";
  }
}
