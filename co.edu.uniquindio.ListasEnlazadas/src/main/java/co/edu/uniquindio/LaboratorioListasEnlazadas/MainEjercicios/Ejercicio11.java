package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.OtrasClases.Polinomio;

public class Ejercicio11 {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio();

        polinomio.add(3, 4);
        polinomio.add(-4, 2);
        polinomio.add(11, 0);

        polinomio.printTableValues(0.0, 5.0, 0.5);
    }
}
