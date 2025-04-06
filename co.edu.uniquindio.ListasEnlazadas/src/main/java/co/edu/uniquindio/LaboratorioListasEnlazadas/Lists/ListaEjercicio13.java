package co.edu.uniquindio.LaboratorioListasEnlazadas.Lists;

public class ListaEjercicio13 {

    NodoEjercicio13 start;

    public ListaEjercicio13() {
        start = null;
    }

    public void add(int amount) {
        start = new NodoEjercicio13(amount, start);
    }

    public int maxDistance(int key) {
        return maxDistanceRecursivo(start, key, 0, -1, 0);
    }

    private int maxDistanceRecursivo(NodoEjercicio13 nodo, int key, int pos, int prevKeyPos, int maxDist) {
        if (nodo == null) {
            return maxDist;
        }

        if (nodo.key == key) {
            if (prevKeyPos == -1) {
                return maxDistanceRecursivo(nodo.next, key, pos + 1, pos, maxDist);

            } else {
                int distance = pos - prevKeyPos;
                if (distance > maxDist) {
                    maxDist = distance;
                }

                return maxDistanceRecursivo(nodo.next, key, pos + 1, pos, maxDist);
            }
        } else {
            return maxDistanceRecursivo(nodo.next, key, pos + 1, prevKeyPos, maxDist);
        }
    }

}

