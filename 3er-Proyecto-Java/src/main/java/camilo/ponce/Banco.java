package camilo.ponce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Banco {
  private final HashMap<Integer, Cliente> clientes = new HashMap<>();
  private final HashMap<Integer, Cuenta> cuentas = new HashMap<>();
  private final HashSet<String> clientesCuentasVarias = new HashSet<>();

  public void agregarCliente(Cliente cliente) {
    clientes.put(cliente.getDni().hashCode(), cliente);
  }

  public Cliente buscarCliente(String dni) {
    return clientes.get(dni.hashCode());
  }
  public Cuenta buscarCuenta(String numeroCuenta) {
    return cuentas.get(numeroCuenta.hashCode());
  }

  public void agregarCuenta(Cuenta cuenta) {
    cuentas.put(cuenta.getNumeroCuenta().hashCode(), cuenta);
    System.out.println("Cuenta agregada al banco.");

    for (Cliente cliente : clientes.values()) {
      if (cliente.getCuentas().contains(cuenta) && cliente.getCuentas().size() > 1) {
        agregarClienteCuentaVarias(cliente);
        break;
      }
    }
  }

  public void agregarClienteCuentaVarias(Cliente cliente) {
    if (!clientesCuentasVarias.contains(cliente.getDni())) {
      clientesCuentasVarias.add(cliente.getDni());
      System.out.println("Cliente agregado a lista con mas de una cuenta.");
    }
  }

  public TreeSet<Cliente> getClientesOrdenados(){
    return new TreeSet<>(clientes.values());
  }

  public ArrayList<Cuenta> getCuentas(String dni){
    return new ArrayList<>(clientes.get(dni.hashCode()).getCuentas());
  }

  public HashSet<String> getClientesCuentasVarias() {
    return clientesCuentasVarias;
   }
}
