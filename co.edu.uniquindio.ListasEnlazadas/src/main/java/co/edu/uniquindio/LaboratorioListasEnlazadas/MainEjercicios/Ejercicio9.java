package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimpleCircular;

public class Ejercicio9 {
        public static void main(String[] args) {
            ListaSimpleCircular<String> fruitList = new ListaSimpleCircular<>();
            fruitList.addEnd("Manzana");
            fruitList.addEnd("Pera");
            fruitList.addEnd("Piña");

            fruitList.printList();

            int position = fruitList.getNodoPosition("Piña");
            if (position != -1) {
                System.out.println("Elemento encontrado en la posición: " + position);
            } else {
                System.out.println("Elemento no encontrado");
            }
        }



}
