/*Clase Moneda
 * @author Gustavo Benítez
 * @version versión 1, 25 de abril 2024*/
class Moneda implements Comparable <Moneda> {
    private int valor;
    public Moneda(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
    @Override
    public int compareTo(Moneda otraMoneda) {
        return Integer.compare(this.valor, otraMoneda.valor);
    }
    @Override
    public String toString() {
        return "Moneda de " + valor;
    }
}
