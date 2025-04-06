package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimple;

import java.util.List;

public class Ejercicio4 {
    public static void main(String[] args) {

        List<Integer> numberList = List.of(2, 5, 7, 8, 10, 11, 13);
        ListaSimple<Integer> oddList = getOddAmounts(numberList);

        System.out.println("Lista enlazada:");
        oddList.printList();
    }

    public static ListaSimple<Integer> getOddAmounts(List<Integer> list) {
        ListaSimple<Integer> odds = new ListaSimple<>();

        for (Integer number : list) {
            if (number % 2 != 0) {
                odds.addEnd(number);
            }
        }

        return odds;
    }
}
