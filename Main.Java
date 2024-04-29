/*Clase Main, todas las pruebas del programa
 * @author Gustavo González
 * @version 2, 29 de abril 2024*/
public class Main {
    public static void main(String[] args) throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {
        /*Crea un expendedor con 5 de cada producto y una moneda de 1000, luego crea un comprador para cada producto e imprime lo que compraron y el vuelto que recibieron*/
        Expendedor exp = new Expendedor(5);
        Moneda m = new Moneda1000();
        Comprador C = new Comprador(m, Expendedor.C1, exp);
        Comprador S = new Comprador(m, Expendedor.S2, exp);
        Comprador F = new Comprador(m, Expendedor.F3, exp);
        Comprador SS = new Comprador(m, Expendedor.S4, exp);
        Comprador S8 = new Comprador(m, Expendedor.S85, exp);
        System.out.println(C.getSaborProducto());
        System.out.println(C.getVuelto());
        System.out.println(S.getSaborProducto());
        System.out.println(S.getVuelto());
        System.out.println(F.getSaborProducto());
        System.out.println(F.getVuelto());
        System.out.println(SS.getSaborProducto());
        System.out.println(SS.getVuelto());
        System.out.println(S8.getSaborProducto());
        System.out.println(S8.getVuelto());
        /*Try y catch para las 3 excepciones*/
        try {
            Moneda M = null;
            Expendedor X = new Expendedor(5);
            Producto Z = X.comprarProducto(M, 1);
        }
        catch (PagoIncorrectoException e) {
            System.out.println("Error de pago incorrecto");
        }
        try {
            Moneda1000 M = new Moneda1000();
            Expendedor X = new Expendedor(0);
            Producto Z = X.comprarProducto(M, 1);
        }
        catch (NoHayProductoException e) {
            System.out.println("Error, no hay producto");
        }
        try {
            Moneda500 M = new Moneda500();
            Expendedor X = new Expendedor(5);
            Producto Z = X.comprarProducto(M, 1);
        }
        catch (PagoInsuficienteException e) {
            System.out.println("Error de pago insuficiente");
        }
    }
}
