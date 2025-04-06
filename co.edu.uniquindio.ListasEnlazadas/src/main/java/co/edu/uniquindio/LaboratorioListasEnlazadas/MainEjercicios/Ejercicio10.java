package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimple;

public class Ejercicio10 {
    public static void main(String[] args) {
        ListaSimple<String> list1 = new ListaSimple<>();
        ListaSimple<String> list2 = new ListaSimple<>();

        list1.addEnd("Gato");
        list1.addEnd("Perro");

        list2.addEnd("Rosado");
        list2.addEnd("Azul");

        ListaSimple<String> concatenatedList = concatenateList(list1, list2);

        System.out.println("Lista concatenada:");
        for (String fact : concatenatedList) {
            System.out.println(fact);
        }
    }

    public static <T> ListaSimple<T> concatenateList(ListaSimple<T> list1, ListaSimple<T> list2) {
        ListaSimple<T> newList = new ListaSimple<>();

        for (T fact : list1) {
            newList.addEnd(fact);
        }

        for (T fact : list2) {
            newList.addEnd(fact);
        }

        return newList;
    }
}
