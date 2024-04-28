/*El expendedor, encargado de crear los depositos hacer la compra y dar el vuelto (con los distintos casos incluidos)
 * @author Gustavo González
 * @version 3, 28 de abril 2024*/
class Expendedor {
    /*Se crean los depositos de los objetos*/
    private Deposito <CocaCola> coca;
    private Deposito <Sprite> sprite;
    private Deposito <Fanta> fanta;
    private Deposito <Snickers> snickers;
    private Deposito <Super8> super8;
    private Deposito <Moneda> monedaDeposito;
    /*El constructor llena "mágicamente" todos los depósitos de productos con la misma cantidad ingresada (numProductos) y llena el depósito de monedas con 20 monedas de 100*/
    public Expendedor(int numProductos) {
        this.coca = new Deposito <CocaCola>();
        this.sprite = new Deposito <Sprite>();
        this.fanta = new Deposito <Fanta>();
        this.snickers = new Deposito <Snickers>();
        this.super8 = new Deposito <Super8>();
        CocaCola C = new CocaCola();
        Sprite S = new Sprite();
        Fanta F = new Fanta();
        Snickers SS = new Snickers();
        Super8 S8 = new Super8();
        for (int i = 0; i < numProductos; i = i + 1) {
            coca.add(C);
            sprite.add(S);
            fanta.add(F);
            snickers.add(SS);
            super8.add(S8);
        }
        this.monedaDeposito = new Deposito <Moneda>();
        Moneda100 MonDep = new Moneda100();
        for (int i = 0; i < 20; i = i + 1) {
            monedaDeposito.add(MonDep);
        }
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
