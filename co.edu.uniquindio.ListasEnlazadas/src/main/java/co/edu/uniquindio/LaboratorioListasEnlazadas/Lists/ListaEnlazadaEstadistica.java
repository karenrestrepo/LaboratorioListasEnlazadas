package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

public class ListaEnlazadaEstadistica {
    private NodoEstadistica head;
    private int size;

    public ListaEnlazadaEstadistica() {
        head = null;
        size = 0;
    }

    public void add(double amount) {
        NodoEstadistica newT = new NodoEstadistica(amount);
        if (head == null) {
            head = newT;
        } else {
            NodoEstadistica current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newT;
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    public double calculateMean() {
        if (head == null) return 0;
        NodoEstadistica current = head;
        double sum = 0;
        while (current != null) {
            sum += current.amount;
            current = current.next;
        }
        return sum / size;
    }

    public double calculateStandardDeviation() {
        double mean = calculateMean();
        double sumDifferenceSquare = 0;
        NodoEstadistica current = head;
        while (current != null) {
            sumDifferenceSquare += Math.pow(current.amount - mean, 2);
            current = current.next;
        }
        return Math.sqrt(sumDifferenceSquare / size);
    }
}
