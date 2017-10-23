package EjercicioEnLinea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author ljpalaciom
 */
public class EjercicioEnLinea1 {

    /**
     * El mismo insertar creado en el taller11
     *
     * @param nodo
     * @param n
     */
    public static void insertar(Nodo nodo, int n) {
        if (n > nodo.valor) {
            if (nodo.der == null) {
                nodo.der = new Nodo(n);
            } else {
                insertar(nodo.der, n);
            }
        } else if (nodo.izq == null) {
            nodo.izq = new Nodo(n);
        } else {
            insertar(nodo.izq, n);
        }
    }

    public static void posOrden(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        posOrden(raiz.izq);
        posOrden(raiz.der);
        System.out.println(raiz.valor);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int n = Integer.parseInt(line);
        Nodo raiz = new Nodo(n);
        while ((line = in.readLine()) != null) {
            try {
                n = Integer.parseInt(line);
                insertar(raiz, n);
            } catch (NumberFormatException e) {
                break;
            }
        }
        posOrden(raiz);
    }
}

class Nodo {

    int valor;
    Nodo izq, der;

    public Nodo(int valor) {
        this.valor = valor;
    }
}
