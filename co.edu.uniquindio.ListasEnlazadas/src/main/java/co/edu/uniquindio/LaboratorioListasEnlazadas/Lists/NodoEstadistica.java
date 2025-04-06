package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

public class NodoEstadistica {
    double amount;
    NodoEstadistica next;

    public NodoEstadistica(double amount) {
        this.amount = amount;
        this.next = null;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public NodoEstadistica getNext() {
        return next;
    }

    public void setNext(NodoEstadistica next) {
        this.next = next;
    }
}
