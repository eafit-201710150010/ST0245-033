package taller9;
//Una tabla de hash donde la llave es un String y el valor un int.

import java.util.ArrayList;
import java.util.LinkedList;

public class UnaTablaDeHash {
    // Ojo, esta tabla definida así no permite manejar las colisiones

    private ArrayList<LinkedList<Pareja>> tabla;
    int size = 10;

    public UnaTablaDeHash() {
        tabla = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            LinkedList linkedList = new LinkedList<>();
            tabla.add(linkedList);
        }
    }

    // Ojo, esta función hash es muy ingenua
    private int funcionHash(String k) {
        int sumatoria = 0;
        for (int i = 0; i < k.length(); i++) {
            sumatoria += (int) k.charAt(i) * Math.pow(2, 31 - i);
        }
        return sumatoria % size;
    }

    // Ojo con las colisiones
    public int get(String k) {
        int pos = funcionHash(k);
        LinkedList enPos = tabla.get(pos);
        for (int i = 0; i < enPos.size(); i++) {
            Pareja actual = (Pareja) enPos.get(i);
            if (k.equals(actual.nombre)) {
                return actual.telefono;
            }
        }
        return -1;
    }

    // Ojo con las colisiones
    public void put(String k, int v) {
        int pos = funcionHash(k);
        System.out.println(pos);
        tabla.get(pos).addFirst(new Pareja(k, v));
    }
}
