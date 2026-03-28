package camilo.ponce;

public class ProductoFisico extends Producto{
  private int stock;

  public ProductoFisico(String nombre, double precio, int id, int stock) {
    super(nombre, precio, id);
    this.stock = stock;
  }

  public int getStock(){
    return stock;
  }

  public void reducirStock(int cantidad){
    stock -= cantidad;
  }

  @Override
  public String toString(){
    return "ProductoFisico{" + "nombre='" + getNombre() + '\'' + ", precio=" + getPrecio() + ", id=" + getId() + ", stock=" + getStock() + '}';
  }
}
