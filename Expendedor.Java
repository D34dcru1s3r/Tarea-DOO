/*El expendedor, encargado de crear los depositos hacer la compra y dar el vuelto (con los distintos casos incluidos)
* @author Gustavo González
* @version 2, 27 de abril 2024*/
class Expendedor {
    /*Se crean los depositos de los objetos*/
    private Deposito <CocaCola> coca;
    private Deposito <Sprite> sprite;
    private Deposito <Fanta> fanta;
    private Deposito <Snickers> snickers;
    private Deposito <Super8> super8;
    private Deposito <Moneda> monedaDeposito;
    /*El constructor llena "mágicamente" todos los depósitos de productos con la misma cantidad ingresada (numProductos)*/
    public Expendedor(int numProductos) {
        this.coca = new Deposito <CocaCola>();
        this.sprite = new Deposito <Sprite>();
        this.fanta = new Deposito <Fanta>();
        this.snickers = new Deposito <Snickers>();
        this.super8 = new Deposito <Super8>();
        CocaCola C = new CocaCola();
        Sprite S = new Sprite();
        for (int i = 0; i < numProductos; i = i + 1) {
            coca.add(C);
            sprite.add(S);
        }
        this.monedaDeposito = new Deposito <Moneda>();
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
