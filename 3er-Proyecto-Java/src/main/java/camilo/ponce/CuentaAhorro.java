package camilo.ponce;

public class CuentaAhorro extends Cuenta {

  public CuentaAhorro(String numeroCuenta, double saldo, Cliente cliente) {
    super(numeroCuenta, saldo);
  }

  public void retirar(double monto) {
    if (monto <= getSaldo()) {
      setSaldo(getSaldo() - monto);
      System.out.println("Retiro exitoso. Nuevo saldo: " + getSaldo());
    } else {
      System.out.println("Saldo insuficiente para realizar el retiro.");
    }
  }

  public String getTipoCuenta(){
    return "Cuenta de ahorro";
  }
}
