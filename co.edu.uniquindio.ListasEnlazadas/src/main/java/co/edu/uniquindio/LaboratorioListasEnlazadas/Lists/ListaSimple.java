package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

import java.util.Iterator;

public class ListaSimple<T> implements Iterable<T> {

    private Nodo<T> firstNodo;
    private Nodo<T> lastNodo;
    private int size;

    public ListaSimple() {
        firstNodo = null;
        lastNodo = null;
        size = 0;
    }

    public void addBeginning (T amountNodo){
        Nodo<T> newNodo = new Nodo<>(amountNodo);

        if(isEmpty()){
            firstNodo = newNodo;

        } else {
            newNodo.setNextNodo(firstNodo);
            firstNodo = newNodo;
        }

        size++;
    }

    public void addEnd (T amountNodo) {
        Nodo<T> nodo = new Nodo<>(amountNodo);

        if (isEmpty()){
            firstNodo = lastNodo = nodo;

        }else{
            lastNodo.setNextNodo(nodo);
            lastNodo = nodo;
        }

        size++;
    }

    public T getAmountNodo(int index){
        Nodo<T> temporaryNodo = null;
        int counter = 0;

        if (validIndex(index)){
            temporaryNodo = firstNodo;
            while (counter < index){
                temporaryNodo = temporaryNodo.getNextNodo();
                counter++;
            }
        }
        if(temporaryNodo != null){
            return temporaryNodo.getAmountNodo();

        }else {
            return null;
        }
    }

    private boolean validIndex(int index){
        if (index >= 0 && index < size){
            return true;
        }
        throw new RuntimeException(("Indice no válido"));
    }


    public boolean isEmpty(){
        return (firstNodo == null) ? true : false;
    }

    public void printList(){
        Nodo<T> aux = firstNodo;

        while (aux != null){
            System.out.println(aux.getAmountNodo()+"\t");
            aux = aux.getNextNodo();
        }
        System.out.println();
    }

    public T delete(T fact){
        Nodo<T> nodo = firstNodo;
        Nodo<T> previous = null;
        Nodo<T> next = null;
        boolean found = false;

        while (nodo != null){
            if (nodo.getAmountNodo() == fact){
                found = true;
                break;
            }
            previous = nodo;
            nodo = nodo.getNextNodo();
        }

        if (found) {
            next = nodo.getNextNodo();
            if (previous == null){
                firstNodo = next;
            }else {
                previous.setNextNodo(next);
            }

            if (next == null){
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

    public T deleteFirst(){
        if(!isEmpty()){
            Nodo<T> n = firstNodo;
            T amount = n.getAmountNodo();
            firstNodo = n.getNextNodo();

            if (firstNodo == null){
                lastNodo = null;
            }

            size--;
            return amount;
        }

        throw new RuntimeException("Lista vacia");
    }

    private Nodo<T> getNodo(int index){
        if (index >= 0 && index < size){
            Nodo<T> nodo = firstNodo;

            for (int i = 0; i < index; i++) {
                nodo = nodo.getNextNodo();
            }

            return nodo;
        }

        return null;
    }

    public void changeNodo(int index, T newN){
        if(validIndex(index)){
            Nodo<T> nodo = getNodo(index);
            nodo.setAmountNodo(newN);
        }
    }

    public int getNodoPosition(T fact){
        int i = 0;

        for (Nodo<T> aux = firstNodo; aux != null; aux = aux.getNextNodo()){
            if (aux.getAmountNodo().equals(fact)){
                return i;
            }
            i++;
        }

        return -1;

    }

    public int countRepetitions(T amount) {
        Nodo<T> current = firstNodo;
        int counter = 0;

        while (current != null) {
            if (current.getAmountNodo().equals(amount)) {
                counter++;
            }
            current = current.getNextNodo();
        }

        return counter;
    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple(firstNodo) {
        };
    }

    protected class IteradorListaSimple implements Iterator<T>{
        private Nodo<T> nodo;
        private int position;

        public IteradorListaSimple(Nodo<T> nodo){
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

        public int getPosition(){ return position;}
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
