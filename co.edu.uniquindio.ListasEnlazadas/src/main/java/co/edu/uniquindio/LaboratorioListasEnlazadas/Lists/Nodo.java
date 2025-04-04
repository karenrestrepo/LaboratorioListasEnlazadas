package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

public class Nodo<T> {
    private Nodo<T> nextNodo;
    private T amountNodo;

    public Nodo(T amountNodo) {this.amountNodo = amountNodo;}

    public Nodo(T fact, Nodo<T> next) {
        super();
        this.amountNodo = fact;
        this.nextNodo = next;
    }

    public Nodo<T> getNextNodo() {
        return nextNodo;
    }

    public void setNextNodo(Nodo<T> nextNodo) {
        this.nextNodo = nextNodo;
    }

    public T getAmountNodo() {
        return amountNodo;
    }

    public void setAmountNodo(T amountNodo) {
        this.amountNodo = amountNodo;
    }
}
