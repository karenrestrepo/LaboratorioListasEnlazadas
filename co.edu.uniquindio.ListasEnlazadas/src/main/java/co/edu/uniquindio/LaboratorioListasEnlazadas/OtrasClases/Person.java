package co.edu.uniquindio.LaboratorioListasEnlazadas.OtrasClases;


public class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " - Cédula: " + id;
    }
}

