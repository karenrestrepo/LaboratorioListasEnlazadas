package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

import java.util.Iterator;

public class ListaSimpleCircular<T> implements Iterable<T> {

    private Nodo<T> firstNodo;
    private Nodo<T> lastNodo;
    private int size;


    public ListaSimpleCircular() {
        firstNodo = null;
        lastNodo = null;
        size = 0;
    }


    public void addBeginning(T amountNodo) {

        Nodo<T> newNodo = new Nodo<>(amountNodo);

        if (isEmpty()) {
            firstNodo = newNodo;
        } else {
            Nodo<T> aux = lastNodo.getNextNodo();
            lastNodo.setNextNodo(newNodo);
            newNodo.setNextNodo(aux);
            lastNodo = newNodo;
        }
        size++;
    }


    public void addEnd(T amountNodo) {

        Nodo<T> newNodo = new Nodo<>(amountNodo);

        if (isEmpty()) {
            firstNodo = lastNodo = newNodo;
        } else {
            Nodo<T> aux = lastNodo.getNextNodo();
            lastNodo.setNextNodo(newNodo);
            newNodo.setNextNodo(aux);
            lastNodo = newNodo;
        }
        size++;
    }


    public T getAmountNodo(int index) {
        Nodo<T> temporaryNodo = null;
        int counter = 0;

        if (validIndex(index)) {
            temporaryNodo = firstNodo;
            while (counter < index) {
                temporaryNodo = temporaryNodo.getNextNodo();
                counter++;
            }
        }
        if (temporaryNodo != null) {
            return temporaryNodo.getAmountNodo();

        } else {
            return null;
        }
    }


    private boolean validIndex(int index) {
        if (index >= 0 && index < size) {
            return true;
        }
        throw new RuntimeException(("Indice no válido"));
    }


    public boolean isEmpty() {
        return (firstNodo == null) ? true : false;
    }


    public void printList() {
        Nodo<T> aux = firstNodo;

        while (aux != null) {
            System.out.println(aux.getAmountNodo() + "\t");
            aux = aux.getNextNodo();
        }
        System.out.println();
    }


    public T delete(T fact) {
        Nodo<T> nodo = firstNodo;
        Nodo<T> previous = null;
        Nodo<T> next = null;
        boolean found = false;

        while (nodo != null) {
            if (nodo.getAmountNodo() == fact) {
                found = true;
                break;
            }
            previous = nodo;
            nodo = nodo.getNextNodo();
        }

        if (found) {
            next = nodo.getNextNodo();
            if (previous == null) {
                firstNodo = next;
            } else {
                previous.setNextNodo(next);
            }

            if (next == null) {
                lastNodo = previous;
            } else {
                nodo.setNextNodo(null);
            }

            nodo = null;
            size--;
            return fact;
        }

        throw new RuntimeException("Elemento no existe");
    }

    public T deleteFirst() {
        if (!isEmpty()) {
            Nodo<T> n = firstNodo;
            T amount = n.getAmountNodo();
            firstNodo = n.getNextNodo();

            if (firstNodo == null) {
                lastNodo = null;
            }

            size--;
            return amount;
        }

        throw new RuntimeException("Lista vacia");
    }


    public T deleteLast() {
        if (!isEmpty()) {
            T amount = lastNodo.getAmountNodo();
            Nodo<T> prev = getNodo(size - 2);
            lastNodo = prev;

            if (lastNodo == null) {
                firstNodo = null;
            } else {
                prev.setNextNodo(null);
            }

            size--;
            return amount;
        }

        throw new RuntimeException("Lista vacía");
    }

    private Nodo<T> getNodo(int index) {
        if (index >= 0 && index < size) {
            Nodo<T> nodo = firstNodo;

            for (int i = 0; i < index; i++) {
                nodo = nodo.getNextNodo();
            }

            return nodo;
        }

        return null;
    }


    public void changeNodo(int index, T newN) {
        if (validIndex(index)) {
            Nodo<T> nodo = getNodo(index);
            nodo.setAmountNodo(newN);
        }
    }


    public int getNodoPosition(T fact) {
        int i = 0;

        for (Nodo<T> aux = firstNodo; aux != null; aux = aux.getNextNodo()) {
            if (aux.getAmountNodo().equals(fact)) {
                return i;
            }
            i++;
        }

        return -1;

    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimpleCircular(firstNodo) {
        };
    }

    protected class IteradorListaSimpleCircular implements Iterator<T> {
        private Nodo<T> nodo;
        private int position;

        public IteradorListaSimpleCircular(Nodo<T> nodo) {
            this.nodo = nodo;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return nodo != null;
        }

        @Override
        public T next() {
            T amount = nodo.getAmountNodo();
            nodo = nodo.getNextNodo();
            position++;
            return amount;
        }

        public int getPosition() {
            return position;
        }
    }

    public Nodo<T> getFirstNodo() {
        return firstNodo;
    }

    public void setFirstNodo(Nodo<T> firstNodo) {
        this.firstNodo = firstNodo;
    }

    public Nodo<T> getLastNodo() {
        return lastNodo;
    }

    public void setLastNodo(Nodo<T> lastNodo) {
        this.lastNodo = lastNodo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
