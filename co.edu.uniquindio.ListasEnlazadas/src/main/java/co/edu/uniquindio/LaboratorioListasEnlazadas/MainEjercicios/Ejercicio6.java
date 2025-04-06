package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaDoble;

public class Ejercicio6 {
    public static void main(String[] args) {

        ListaDoble<Integer> list = new ListaDoble<>();

        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(3);
        list.addEnd(4);
        list.addEnd(5);
        list.addEnd(6);


        System.out.println("Lista hacia atrás:");
        list.printBackwards();
    }
}
