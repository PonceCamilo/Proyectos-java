package camilo.ponce;

import java.time.LocalDate;

public class Transaccion {
  private final String tipo;
  private final double monto;
  private final String fecha = LocalDate.now().toString();

  public Transaccion(String tipo, double monto) {
    this.tipo = tipo;
    this.monto = monto;
  }

  public String toString() {
    return "Transaccion{" + "tipo='" + tipo + '\'' + ", monto=" + monto + ", fecha=" + fecha + '}';
  }
}
