/*Clase Producto
* @author Gustavo Benítez
* @version versión 1, 25 de abril 2024*/
abstract class Producto {
    private String nombre;
    private int precio;
    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
}
