public class Main {
    public static void main(String[] args) throws PagoIncorrectoException, NoHayProductoException {
        Expendedor exp = new Expendedor(5);
        Moneda m = new Moneda1000();
        Comprador C = new Comprador(m, 1, exp);
        System.out.println(C.getSaborProducto());
        System.out.println(C.getVuelto());
        /*try {
            Comprador comprador = new Comprador(m, 1, exp);
            System.out.println("Producto comprado: " + comprador.getSaborProducto());
            System.out.println("Cantidad total: " + comprador.getVuelto());
            int vuelto = comprador.getVuelto();
            while (vuelto != 0) {
                System.out.println("Moneda de vuelto: " + vuelto);
            }
        }
        catch (NoHayProductoException | PagoIncorrectoException e) {
            System.out.println("Se produjo un error durante la compra: " + e.getMessage());
        }*/
    }
}
