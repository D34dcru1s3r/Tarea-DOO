/*Clase enum Productos
 * @author Gustavo González
 * @version versión 2, 28 de abril 2024*/
public enum Productos {
    COCACOLA("cocacola", 1500),
    SPRITE("sprite", 1200),
    FANTA("fanta", 1000),
    SNICKERS("snickers", 800),
    SUPER8("super8", 500);
    private final String nombre;
    private final int precio;
    Productos(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public int getPrecio() {
        return precio;
    }
    public String getNombre() {
        return nombre;
    }
}
