package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;
public class ListaDobleCircular<T> {

    private NodoDoble<T> firstNodo;
    private NodoDoble<T> lastNodo;
    private int size;

    public ListaDobleCircular() {
        firstNodo = null;
        lastNodo = null;
        size = 0;
    }


    public void add( T amount, int position ) {
        int cont = 0;

        for(NodoDoble<T> aux = firstNodo; cont < size; cont++, aux = aux.getNextNodo() ) {
            if( cont == position ) {
                NodoDoble<T> aux2 = aux.getPreviousNodo();
                NodoDoble<T> newN = new NodoDoble<>( amount );
                aux2.setNextNodo( newN );
                newN.setNextNodo( aux );
                newN.setPreviousNodo( aux2 );
                aux.setPreviousNodo( newN );
                size++;
            }
        }
    }


    public int search(T amount ) {
        int cont = 0;
        int pos = -1;

        for(NodoDoble<T> aux = firstNodo; cont < size; cont++, aux = aux.getNextNodo() ) {
            if( aux.getAmountNodo().equals( amount ) ) {
                pos = cont;
            }
        }
        return pos;
    }

    public void addEnd(T amountNodo) {

        NodoDoble<T> newNodo = new NodoDoble<>( amountNodo );

        if( isEmpty() ) {
            firstNodo = lastNodo = newNodo;
        }
        else {
            newNodo.setNextNodo(firstNodo);
            firstNodo.setPreviousNodo(newNodo);
            lastNodo.setNextNodo(newNodo);
            newNodo.setPreviousNodo(lastNodo);
            firstNodo = newNodo;
        }
        size++;
    }

    public boolean isEmpty() {
        return firstNodo == null && lastNodo == null;
    }


    public void printList() {

        NodoDoble<T> aux = firstNodo;
        int cont = 0;

        while( aux!=null && cont != size) {
            System.out.print( aux.getAmountNodo()+"\t" );
            aux = aux.getNextNodo();
            cont ++;
        }

        System.out.println();
    }

}
