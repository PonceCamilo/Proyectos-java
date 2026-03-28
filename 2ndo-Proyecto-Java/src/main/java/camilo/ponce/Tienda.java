package camilo.ponce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tienda{
  private final ArrayList<Producto> Productos;
  private final ArrayList<Empleado> Empleados;

  public Tienda(){
    Productos = new ArrayList<>();
    Empleados = new ArrayList<>();
  }

  public ArrayList<Producto> getProductos() {
    return Productos;
  }

  public ArrayList<ProductoFisico> getProductosFisicos() {
    ArrayList<ProductoFisico> productosFisicos = new ArrayList<>();
    for (Producto p : Productos) {
      if (p instanceof ProductoFisico)
        productosFisicos.add((ProductoFisico) p);
      }
    return productosFisicos;
  }

  public void agregarProducto(Producto p){
    if(Productos.size() < 10){
      Productos.add(p);
    } else{
      System.out.print("Cantidad maxima de productos alcanzada");
    }
  }

  public Producto getProducto(int id){
    Optional<Producto> producto = Productos.stream().filter(p -> p.getId() == id).findFirst();
    return producto.orElse(null);
  }

  public ProductoFisico getProductoFisico(int id){
    Optional<Producto> producto = Productos.stream().filter(p -> p.getId() == id).findFirst();
    if(producto.isPresent() && producto.get() instanceof ProductoFisico){
      return (ProductoFisico) producto.get();
    } else {
      return null;
    }
  }

  public void agregarEmpleado(Empleado e){
    if(Empleados.size() < 5){
      Empleados.add(e);
    } else{
      System.out.print("Cantidad maxima de empleados alcanzada");
    }
  }

  public List<Empleado> getEmpleados(){
    return Empleados;
  }

  public Double calcularNominaMensual(){
    double total = 0;
    for(Empleado e : Empleados){
      total += e.calcularSueldo();
    }
    return total;
  }

  public void venderProductoFisico(int id, int cantidad){
    ProductoFisico pf = getProductoFisico(id);
    if(cantidad <= pf.getStock()) {
      pf.reducirStock(cantidad);
      System.out.println("Venta realizada con exito.");
      if(pf.getStock() == 0){
        Productos.remove(pf);
      }
    } else {
      System.out.println("No se pudo completar la venta por falta de stock.");
    }
  }
}
