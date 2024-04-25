package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Expendedor expendedor = new Expendedor(100);

        Moneda moneda = new Moneda100(1000);

        try {
            Comprador comprador = new Comprador(moneda, 1, expendedor);
            System.out.println("Producto comprado: " + comprador.getProductoConsumido());
            System.out.println("Cantidad total: " + comprador.getCantidadTotal());

            comprador.consumirProducto();

            Moneda vuelto;
            while ((vuelto = comprador.getVuelto()) != null) {
                System.out.println("Moneda de vuelto: " + vuelto);
            }
        } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException e) {
            System.out.println("Se produjo un error durante la compra: " + e.getMessage());
        }
    }