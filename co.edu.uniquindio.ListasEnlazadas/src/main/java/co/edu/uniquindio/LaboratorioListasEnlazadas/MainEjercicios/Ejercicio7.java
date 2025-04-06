package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaDoble;

public class Ejercicio7 {
    public static void main(String[] args) {

        ListaDoble<Integer> list = new ListaDoble<>();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);

        System.out.println("Recorrido hacia adelante:");
        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("\nRecorrido hacia atrás:");
        ListaDoble<Integer>.IteradorListaDoble iterador = list.new IteradorListaDoble(list.getLastNodo());

        while (iterador.hasPrevious()) {
            System.out.println(iterador.previous());
        }
    }
}
