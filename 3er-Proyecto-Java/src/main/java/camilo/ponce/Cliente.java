package camilo.ponce;

import java.util.ArrayList;

public class Cliente {
  private final String nombre;
  private final String dni;
  private final String email;
  private final ArrayList<Cuenta> cuentas = new ArrayList<>();

  public Cliente(String nombre, String dni, String email) {
    this.nombre = nombre;
    this.dni = dni;
    this.email = email;
  }

  public String getDni() {
    return dni;
  }

  public ArrayList<Cuenta> getCuentas() {
    return cuentas;
  }

  public void agregarCuenta(Cuenta cuenta) {
    cuentas.add(cuenta);
  }

  public String toString() {
    return "Cliente{" + "nombre='" + nombre + '\'' + ", dni='" + dni + '\'' + ", email='" + email + '\'' + '}';
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cliente cliente = (Cliente) o;
    return nombre.equals(cliente.nombre) && dni.equals(cliente.dni) && email.equals(cliente.email);
  }
}
