import java.util.ArrayList;
/*Deposito de tipo genérico
* @author Gustavo González
* @version 2, 26 de abril de 2024*/
class Deposito <T> {
    /*ArrayList para almacenar los objetos*/
    private ArrayList <T> items = new ArrayList<>();
    /*El constructor no es necesario*/
    public Deposito() {}
    /*Si el ArrayList (Deposito) esta vacío:
    * @return null
    * si el ArrayList no esta vacío:
    * @return el objeto en el index 0 y remueve ese mismo objeto del ArrayList*/
    public T get() {
        if (!items.isEmpty()) {
            return items.remove(0);
        }
        return null;
    }
    /*Añade un objeto del tipo <T> al Deposito*/
    public void add(T item) {
        items.add(item);
    }
}
