package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimple;

public class Ejercicio5 {
    public static void main(String[] args) {

        ListaSimple<Integer> list = new ListaSimple<>();

        list.addEnd(5);
        list.addEnd(3);
        list.addEnd(7);
        list.addEnd(5);
        list.addEnd(2);
        list.addEnd(5);


        int search = 5;
        int repetitions = list.countRepetitions(search);

        System.out.println("El valor " + search + " se repite " + repetitions + " veces.");
    }
}
