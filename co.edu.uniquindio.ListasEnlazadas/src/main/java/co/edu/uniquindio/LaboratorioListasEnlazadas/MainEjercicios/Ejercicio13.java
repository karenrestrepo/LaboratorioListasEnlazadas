package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaEjercicio13;

public class Ejercicio13 {
    public static void main(String[] args) {
        ListaEjercicio13 list = new ListaEjercicio13();

        list.add(1);
        list.add(4);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(1);
        list.add(4);

        int key = 4;
        int distance = list.maxDistance(key);
        System.out.println("Máxima distancia para la clave " + key + " es: " + distance);
    }
}
