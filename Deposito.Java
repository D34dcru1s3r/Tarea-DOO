public class Deposito<T> {
    private T contenido;

    public Deposito() {
        this.contenido = null;
    }

    public T getContenido() {
        return contenido;
    }

    public void almacenar(T item) {
        this.contenido = item;
    }
}