package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

public class NodoDoble<T> {

    private NodoDoble<T> nextNodo;
    private NodoDoble<T> previousNodo;
    private T amountNodo;


    public NodoDoble(T amountNodo) {
        this.amountNodo = amountNodo;
    }


    public NodoDoble(T fact, NodoDoble<T> next, NodoDoble<T> previous) {
        super();
        this.amountNodo = fact;
        this.nextNodo = next;
        this.previousNodo = previous;
    }

    public NodoDoble<T> getNextNodo() {
        return nextNodo;
    }

    public void setNextNodo(NodoDoble<T> nextNodo) {
        this.nextNodo = nextNodo;
    }

    public NodoDoble<T> getPreviousNodo() {
        return previousNodo;
    }

    public void setPreviousNodo(NodoDoble<T> previousNodo) {
        this.previousNodo = previousNodo;
    }

    public T getAmountNodo() {
        return amountNodo;
    }

    public void setAmountNodo(T amountNodo) {
        this.amountNodo = amountNodo;
    }
}
