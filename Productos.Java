/*Clase enum Productos
 * @author Gustavo González
 * @version versión 2, 28 de abril 2024*/
public enum Productos {
    COCACOLA("CocaCola", 1000),
    SPRITE("Sprite", 800),
    FANTA("Fanta", 600),
    SNICKERS("Snickers", 500),
    SUPER8("Super8", 300);
    private final String nombre;
    private final int precio;
    Productos(String nombre, int precio) {
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
