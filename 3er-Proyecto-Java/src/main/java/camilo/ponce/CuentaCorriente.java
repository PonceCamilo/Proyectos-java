package camilo.ponce;

public class CuentaCorriente extends Cuenta{
  private final double limiteDescubierto;

  public CuentaCorriente(String numeroCuenta, double saldo, Cliente cliente, double limiteDescubierto) {
    super(numeroCuenta, saldo);
    this.limiteDescubierto = limiteDescubierto;
  }

  public void retirar(double monto) {
    double saldoDisponible = getSaldo() + limiteDescubierto;

    if (saldoDisponible >= monto) {
      setSaldo(getSaldo() - monto);
      System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
    } else {
      System.out.println("Saldo insuficiente para realizar el retiro.");
    }
  }

  @Override
  public String getTipoCuenta() {
    return "Cuenta Corriente";
  }

}
