public class Comprador {
    private Moneda moneda;
    private int numeroProducto;
    private Expendedor<Producto> expendedor;
    private String saborProducto;
    private int cantidadTotalMonedas;

    public Comprador(Moneda moneda, int numeroProducto, Expendedor<Producto> expendedor) {
        this.moneda = moneda;
        this.numeroProducto = numeroProducto;
        this.expendedor = expendedor;
    }

    public Producto comprarProducto() throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        Producto producto = expendedor.dispensarProducto(moneda, numeroProducto);
        if (producto != null) {
            saborProducto = producto.getNombre();
            cantidadTotalMonedas = 0;
            return producto;
        } else {
            throw new NoHayProductoException("No hay producto disponible o no se pudo comprar con la moneda proporcionada.");
        }
    }

    public String getSaborProducto() {
        return saborProducto;
    }

    public Moneda obtenerMonedaVuelto() {
        if (cantidadTotalMonedas > 0) {
            cantidadTotalMonedas--;
            return new Moneda100();
        } else {
            return null;
        }
    }

    public int getCantidadTotalMonedas() {
        return cantidadTotalMonedas;
    }
}