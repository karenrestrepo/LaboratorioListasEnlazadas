package co.edu.uniquindio.LaboratorioListasEnlazadas.MainEjercicios;

import co.edu.uniquindio.LaboratorioListasEnlazadas.Lists.ListaEnlazadaEstadistica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio12 {
    public static void main(String[] args) {
        ListaEnlazadaEstadistica lista = new ListaEnlazadaEstadistica();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/numeros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                double number = Double.parseDouble(line);
                lista.add(number);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("Cantidad de números: " + lista.getSize());
        System.out.printf("Media: %.3f\n", lista.calculateMean());
        System.out.printf("Desviación Estándar: %.3f\n", lista.calculateStandardDeviation());
    }
}
