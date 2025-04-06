package co.edu.uniquindio.LaboratorioListasEnlazadas.OtrasClases;

public class Polinomio {
    private Termino head;

    public Polinomio() {
        head = null;
    }

    public void add(double coef, int exp) {
        Termino newT = new Termino(coef, exp);
        if (head == null) {
            head = newT;
        } else {
            Termino current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newT;
        }
    }

    public double assess(double x) {
        double result = 0;
        Termino current = head;
        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent);
            current = current.next;
        }
        return result;
    }

    public void printTableValues(double start, double end, double step) {
        System.out.println("x\tP(x)");
        for (double x = start; x <= end; x += step) {
            System.out.printf("%.1f\t%.4f\n", x, assess(x));
        }
    }
}

