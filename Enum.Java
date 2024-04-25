public enum Producto {
    COCACOLA(150),
    SPRITE(120),
    FANTA(130),
    SNICKERS(100),
    SUPER8(80);

    private final int precio;

    Producto(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return this.name().toLowerCase();
    }

    public String getDescripcion() {
        return "Producto: " + this.name() + ", Precio: $" + precio;
    }
}