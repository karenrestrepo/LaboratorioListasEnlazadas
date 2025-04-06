package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

import java.util.Iterator;

public class ListaDoble<T> implements Iterable<T> {

    private NodoDoble<T> firstNodo;
    private NodoDoble<T> lastNodo;
    private int size;


    public ListaDoble() {
        firstNodo = null;
        lastNodo = null;
        size = 0;
    }


    public void addBeginning(T valorNodo) {

        NodoDoble<T> newNodo = new NodoDoble<>(valorNodo);

        if (isEmpty()) {
            firstNodo = lastNodo = newNodo;
        } else {
            newNodo.setNextNodo(firstNodo);
            firstNodo = newNodo;
        }
        size++;
    }


    public void addEnd(T amountNodo) {

        NodoDoble<T> newNodo = new NodoDoble<>(amountNodo);

        if (isEmpty()) {
            firstNodo = lastNodo = newNodo;
        } else {
            lastNodo.setNextNodo(newNodo);
            newNodo.setPreviousNodo(lastNodo);
            lastNodo = newNodo;
        }
        size++;
    }


    public void add(T fact, int index) {

        if (validIndex(index)) {

            if (index == 0) {
                addBeginning(fact);
            } else {
                NodoDoble<T> newN = new NodoDoble<>(fact);
                NodoDoble<T> current = getNodo(index);

                newN.setNextNodo(current);
                newN.setPreviousNodo(current.getPreviousNodo());
                current.getPreviousNodo().setNextNodo(newN);
                current.setPreviousNodo(newN);

                size++;
            }
        }
    }


    public void deleteList() {
        firstNodo = lastNodo = null;
        size = 0;
    }

    public T getAmountNodo(int index) {
        NodoDoble<T> temporaryNodo = null;
        int counter = 0;

        if (validIndex(index)) {
            temporaryNodo = firstNodo;

            while (counter < index) {
                temporaryNodo = temporaryNodo.getNextNodo();
                counter++;
            }
        }

        if (temporaryNodo != null)
            return temporaryNodo.getAmountNodo();
        else
            return null;
    }


    private boolean validIndex(int index) {
        if (index >= 0 && index < size) {
            return true;
        }
        throw new RuntimeException("Indice no válido");
    }


    public boolean isEmpty() {
        return firstNodo == null && lastNodo == null;
    }


    public void printList() {

        NodoDoble<T> aux = firstNodo;

        while (aux != null) {
            System.out.print(aux.getAmountNodo() + "\t");
            aux = aux.getNextNodo();
        }

        System.out.println();
    }

    public void printBackwards() {

        for (NodoDoble<T> aux = lastNodo; aux != null; aux = aux.getPreviousNodo()) {
            System.out.print(aux.getAmountNodo() + "\t");
        }
        System.out.println();

    }


    public T delete(T fact) {

        NodoDoble<T> nodo = searchNodo(fact);

        if (nodo != null) {

            NodoDoble<T> previous = nodo.getPreviousNodo();
            NodoDoble<T> next = nodo.getNextNodo();

            if (previous == null) {
                firstNodo = next;
            } else {
                previous.setNextNodo(next);
            }

            if (next == null) {
                lastNodo = previous;
            } else {
                next.setPreviousNodo(previous);
            }

            nodo = null;
            size--;

            return fact;
        }

        throw new RuntimeException("El amount no existe");
    }


    public T deleteFirst() {

        if (!isEmpty()) {
            NodoDoble<T> nodoAux = firstNodo;
            T amount = nodoAux.getAmountNodo();
            firstNodo = nodoAux.getNextNodo();

            if (firstNodo == null) {
                lastNodo = null;
            } else {
                firstNodo.setPreviousNodo(null);
            }

            size--;
            return amount;
        }

        throw new RuntimeException("Lista vacía");
    }


    public T deleteLast() {
        if (!isEmpty()) {
            T amount = lastNodo.getAmountNodo();
            NodoDoble<T> prev = getNodo(size - 2);
            lastNodo = prev;

            if (lastNodo == null) {
                firstNodo = null;
            } else {
                prev.setNextNodo(null);
            }

            size--;
            return amount;
        }

        throw new RuntimeException("Lista vac�a");
    }


    private NodoDoble<T> getNodo(int index) {

        if (index >= 0 && index < size) {
            NodoDoble<T> nodo = firstNodo;

            for (int i = 0; i < index; i++) {
                nodo = nodo.getNextNodo();
            }

            return nodo;
        }

        return null;
    }


    private NodoDoble<T> searchNodo(T fact) {
        NodoDoble<T> aux = firstNodo;

        while (aux != null) {
            if (aux.getAmountNodo().equals(fact)) {
                return aux;
            }
            aux = aux.getNextNodo();
        }

        return null;
    }


    public void changeNodo(int index, T newN) {

        if (validIndex(index)) {
            NodoDoble<T> nodo = getNodo(index);
            nodo.setAmountNodo(newN);
        }

    }


    public int getNodoPosition(T fact) {
        int i = 0;

        for (NodoDoble<T> aux = firstNodo; aux != null; aux = aux.getNextNodo()) {
            if (aux.getAmountNodo().equals(fact)) {
                return i;
            }
            i++;
        }
        return -1;
    }


    public T get(int index) {
        if (validIndex(index)) {
            NodoDoble<T> n = getNodo(index);

            if (n != null) {
                return n.getAmountNodo();
            }
        }
        return null;
    }


    @Override
    public Iterator<T> iterator() {

        return new IteradorListaDoble(firstNodo);
    }

    public class IteradorListaDoble implements Iterator<T> {

        private NodoDoble<T> nodo;
        private int position;


        public IteradorListaDoble(NodoDoble<T> nodo) {
            this.nodo = nodo;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return nodo != null;
        }

        @Override
        public T next() {
            T valor = nodo.getAmountNodo();
            nodo = nodo.getNextNodo();
            position++;
            return valor;
        }

        public boolean hasPrevious() {
            return nodo != null;
        }


        public T previous() {
            T aux = nodo.getAmountNodo();
            nodo = nodo.getPreviousNodo();
            position--;
            return aux;
        }

        public int nextIndex() {
            return position;
        }


        public int previousIndex() {
            return position - 1;
        }

        public void remove() {
            if (nodo != null) {
                delete(nodo.getAmountNodo());
            }
        }

        public void set(T e) {
            if (nodo != null) {
                nodo.setAmountNodo(e);
            }
        }

        public void add(T e) {
            addEnd(e);
        }


        public int getPosicion() {
            return position;
        }

    }

    public NodoDoble<T> getFirstNodo() {
        return firstNodo;
    }

    public void setFirstNodo(NodoDoble<T> firstNodo) {
        this.firstNodo = firstNodo;
    }

    public NodoDoble<T> getLastNodo() {
        return lastNodo;
    }

    public void setLastNodo(NodoDoble<T> lastNodo) {
        this.lastNodo = lastNodo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
