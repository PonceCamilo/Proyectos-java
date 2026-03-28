package camilo.ponce;

public abstract class Cuenta {
  private final String numeroCuenta;
  private double saldo;

  public Cuenta(String numeroCuenta, double saldo) {
    this.numeroCuenta = numeroCuenta;
    this.saldo = saldo;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }
  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public abstract String getTipoCuenta();
  public abstract void retirar(double cantidad);
  public void depositar(double cantidad) {
    if (cantidad > 0) {
      saldo += cantidad;
      System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
    } else {
      System.out.println("El monto a depositar debe ser mayor a cero.");
    }
  }


  @Override
  public String toString() {
    return "Cuenta{" + "numeroCuenta='" + numeroCuenta + '\'' + ", saldo=" + saldo + '}';
  }

  public boolean equals(Object o) {
    return this.getNumeroCuenta().equals(((Cuenta) o).getNumeroCuenta());
  }
}
