public class Moneda implements Comparable<Moneda> {
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