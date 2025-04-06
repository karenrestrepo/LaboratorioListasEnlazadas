package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimple;

public class Ejercicio3 {
    public static void main(String[] args) {

        ListaSimple<Integer> list = new ListaSimple<>();

        list.addEnd(3);
        list.addEnd(6);
        list.addEnd(9);
        list.addEnd(12);
        list.addEnd(15);
        list.addEnd(18);


        for (int i = list.getSize() - 1; i >= 0; i--) {
            Integer num = list.getAmountNodo(i);
            if (num % 2 == 0) {
                list.delete(num);
            }
        }

        System.out.println("Lista después de eliminar los números pares:");
        list.printList();
    }
}
