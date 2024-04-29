/*Clase Comprador
 * @author Gustavo González
 * @version 2, 28 de abril 2024*/
class Comprador {
    private String saborProducto;
    private int vuelto = 0;
    /*El comprador recibe una moneda m, el número del producto a comprar y el expendedor donde lo va a comprar.
    * Se compra el producto con la función y se guarda el valor en P.
    * Si P es distinto de null, le asigna a saborProducto el valor correspondiente con getNombre.
    * Luego, saca las monedas del depósito de vuelto del expendedor y suma sus valores.*/
    public Comprador(Moneda m, int numProducto, Expendedor exp) throws PagoIncorrectoException, NoHayProductoException {
        Producto P = exp.comprarProducto(m, numProducto);
        this.saborProducto = P != null ? P.getNombre() : "null";
        while(exp.getVuelto() != null) {
            this.vuelto = vuelto + exp.getVuelto().getValor();
        }
    }
    /*Función que devuelve el sabor del producto, equivalente a preguntarle que comió.*/
    public String getSaborProducto() {
        return saborProducto;
    }
    /*Función que devuelve la cantidad total del vuelto.*/
    public int getVuelto() {
        return vuelto;
    }
}
