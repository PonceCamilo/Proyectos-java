package camilo.ponce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tienda{
  private final ArrayList<Producto> productos = new ArrayList<>();
  private final ArrayList<Empleado> empleados = new ArrayList<>();

  public ArrayList<Producto> getProductos() {
    return productos;
  }

  public ArrayList<ProductoFisico> getProductosFisicos() {
    ArrayList<ProductoFisico> productosFisicos = new ArrayList<>();
    for (Producto p : productos) {
      if (p instanceof ProductoFisico)
        productosFisicos.add((ProductoFisico) p);
      }
    return productosFisicos;
  }

  public void agregarProducto(Producto p){
    if(productos.size() < 10){
      productos.add(p);
    } else{
      System.out.print("Cantidad maxima de productos alcanzada");
    }
  }

  public Producto getProducto(int id){
    Optional<Producto> producto = productos.stream().filter(p -> p.getId() == id).findFirst();
    return producto.orElse(null);
  }

  public ProductoFisico getProductoFisico(int id){
    Optional<Producto> producto = productos.stream().filter(p -> p.getId() == id).findFirst();
    if(producto.isPresent() && producto.get() instanceof ProductoFisico){
      return (ProductoFisico) producto.get();
    } else {
      return null;
    }
  }

  public void agregarEmpleado(Empleado e){
    if(empleados.size() < 5){
      empleados.add(e);
    } else{
      System.out.print("Cantidad maxima de empleados alcanzada");
    }
  }

  public List<Empleado> getEmpleados(){
    return empleados;
  }

  public double calcularNominaMensual(){
    double total = 0;
    for(Empleado e : empleados){
      total += e.calcularSueldo();
    }
    return total;
  }

  public void venderProductoFisico(int id, int cantidad){
    ProductoFisico pf = getProductoFisico(id);
    if(cantidad <= pf.getStock()) {
      pf.reducirStock(pf, cantidad);
      System.out.println("Venta realizada con exito.");
      if(pf.getStock() == 0){
        productos.remove(pf);
      }
    } else {
      System.out.println("No se pudo completar la venta por falta de stock.");
    }
  }
}
