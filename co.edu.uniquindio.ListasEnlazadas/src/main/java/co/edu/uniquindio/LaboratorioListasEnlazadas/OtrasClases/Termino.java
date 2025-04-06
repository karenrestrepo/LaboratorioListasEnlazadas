package co.edu.uniquindio.LaboratorioListasEnlazadas.OtrasClases;

public class Termino {
    double coefficient;
    int exponent;
    Termino next;

    public Termino(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

