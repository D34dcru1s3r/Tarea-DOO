public class Expendedor<T extends Producto> {
    private int cantidadMonedasVuelto;
    private List<Deposito<T>> depositosProductos;
    private List<Moneda> monedasVuelto;

    public Expendedor(int cantidadMonedas) {
        this.cantidadMonedasVuelto = cantidadMonedas;
        this.depositosProductos = new ArrayList<>();
        this.monedasVuelto = new ArrayList<>();
    }

    public T dispensarProducto(Moneda moneda, int numeroDeposito) throws PagoIncorrectoException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("La moneda es nula");
        }

        Deposito<T> deposito = getDeposito(numeroDeposito);
        if (deposito == null || deposito.obtenerProducto() == null || moneda.getValor() < deposito.obtenerProducto().getPrecio()) {
            monedasVuelto.add(moneda);
            throw new NoHayProductoException("El número de depósito es erróneo, no hay producto o no alcanza");
        }

        T producto = deposito.obtenerProducto();
        int precio = producto.getPrecio();
        if (moneda.getValor() > precio) {
            int vuelto = moneda.getValor() - precio;
            while (vuelto >= 100) {
                monedasVuelto.add(new Moneda(100));
                vuelto -= 100;
            }
        }

        moneda = null;

        return producto;
    }

    private Deposito<T> getDeposito(int numeroDeposito) {
        for (Deposito<T> deposito : depositosProductos) {
            if (deposito.getNumeroDeposito() == numeroDeposito) {
                return deposito;
            }
        }
        return null;
    }
}