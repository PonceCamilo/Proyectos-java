package camilo.ponce;

public class ProductoDigital extends Producto{
  private final String urlDescarga;

  public ProductoDigital(String nombre, double precio, int id, String urlDescarga) {
    super(nombre, precio, id);
    this.urlDescarga = urlDescarga;
  }

  @Override
  public String toString(){
    return "ProductoDigital{" + "nombre='" + getNombre() + '\'' + ", precio=" + getPrecio() + ", id=" + getId() + ", urlDescarga='" + urlDescarga + '\'' + '}';
  }
}
