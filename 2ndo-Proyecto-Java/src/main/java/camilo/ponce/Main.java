package camilo.ponce;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {

    Tienda tienda = new Tienda();

    tienda.agregarEmpleado(new EmpleadoFijo("Camilo Ponce", 123, 1000.00));
    tienda.agregarEmpleado(new EmpleadoFreelance("Maria Gomez", 124, 150.00, 8));
    tienda.agregarProducto(new ProductoFisico("Laptop", 1500.00, 1, 1));
    tienda.agregarProducto(new ProductoDigital("Juego", 10.00, 2, "xdd"));
    tienda.agregarProducto(new ProductoDigital("Libro", 5.00, 3, "jejes"));
    tienda.agregarProducto(new ProductoFisico("celular", 1900.00, 4, 3));

    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
      System.out.println("== TIENDA: Mi Tienda Tech ==");

      System.out.println("--- Menu ---");
      System.out.println("1.  Listar Productos");
      System.out.println("2.  Buscar producto por id");
      System.out.println("3.  Vender producto fisico");
      System.out.println("4.  Listar Empleados");
      System.out.println("5.  Ver nomina mensual");
      System.out.println("6.  Salir");

      System.out.print("Tu opcion: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          System.out.println("Productos:");
          for (Producto p : tienda.getProductos()) {
            System.out.println(p);
          }
          break;
        case 2:
          System.out.print("Introduce el id del producto: ");
          int id = scanner.nextInt();
          if (tienda.getProducto(id) == null) {
            System.out.println("Producto no encontrado");
            break;
          }
          System.out.println("Producto encontrado: " + tienda.getProducto(id));
          break;
        case 3:
          if(tienda.getProductosFisicos() == null){
            System.out.println("No hay productos fisicos en la tienda.");
            break;
          }
          System.out.println("Productos fisicos a la venta: ");
          tienda.getProductosFisicos().forEach(pf -> System.out.println(pf.getNombre() + ", id: " + pf.getId() + ", Precio: " + pf.getPrecio() + ", Stock: " + pf.getStock()));
          System.out.print("Introduce el id del producto fisico a vender: ");
          int idVenta = scanner.nextInt();
          if (tienda.getProductosFisicos().stream().noneMatch(p -> p.getId() == idVenta)) {
            System.out.println("Producto no encontrado o no es fisico");
            break;
          }
          System.out.println("Introduce la cantidad a vender: ");
          int cantidad = scanner.nextInt();
          tienda.venderProductoFisico(idVenta, cantidad);
          break;
        case 4:
          System.out.println("Empleados: ");
          for (Empleado e : tienda.getEmpleados()) {
            e.imprimir();
          }
          break;
        case 5:
          System.out.println("Nomina mensual: " + tienda.calcularNominaMensual());
          break;
        case 6:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion no valida");
      }

    } while (opcion != 6);

    scanner.close();
  }
}
