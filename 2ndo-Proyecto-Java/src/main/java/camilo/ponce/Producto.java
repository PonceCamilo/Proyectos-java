package camilo.ponce;

public class Producto {
  private final String nombre;
  private final double precio;
  private final int id;

  public Producto(String nombre, double precio, int id) {
    this.nombre = nombre;
    if (precio < 0) {
      throw new IllegalArgumentException("El precio no puede ser negativo");
    } else {
      this.precio = precio;
    }
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Producto{" + "nombre='" + nombre + '\'' + ", precio=" + precio + ", id=" + id + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    } else {
      return this.getId() == ((Producto) obj).getId();
    }
  }
}
