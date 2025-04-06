package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaDoble;
import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaSimple;
import co.edu.uniquindio.LaboratorioListasEnlazadas.OtrasClases.Person;

public class Ejercicio8 {
    public static void main(String[] args) {

        ListaDoble<Person> people = new ListaDoble<>();

        people.addEnd(new Person("Julian", "100534"));
        people.addEnd(new Person("Vanessa", "10948862"));
        people.addEnd(new Person("Camilo", "1007329"));
        people.addEnd(new Person("Daira", "10955506"));

        System.out.println("Personas con cédula de longitud par:");

        for (int i = 0; i < people.getSize(); i++) {
            Person p = people.getAmountNodo(i);
            if (p.getId().length() % 2 == 0) {
                System.out.println(p);
            }
        }
    }
}
