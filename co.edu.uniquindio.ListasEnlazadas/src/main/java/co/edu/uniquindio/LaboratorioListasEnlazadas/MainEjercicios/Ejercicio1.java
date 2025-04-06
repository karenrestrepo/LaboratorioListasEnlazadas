package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimple;

public class Ejercicio1 {

    public static void main(String[] args) {

        ListaSimple<Integer> list = new ListaSimple<>();

        list.addEnd(3);
        list.addEnd(6);
        list.addEnd(9);
        list.addEnd(12);
        list.addEnd(15);
        list.addEnd(18);

        System.out.println("Elementos en posiciones impares:");

        for (int i = 0; i < list.getSize(); i++) {
            if (i % 2 != 0) {
                System.out.println(list.getAmountNodo(i));
            }
        }
    }
}

