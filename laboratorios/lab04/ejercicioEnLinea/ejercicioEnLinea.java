package lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author scastrillg
 */
public class ejercicioEnLinea {

    static Stack arrayBlock[];

    private static int buscar(int a) {
        for (int i = 0; i < arrayBlock.length; i++) {
            if (arrayBlock[i].contains(a)) {
                return i;
            }
        }
        return 0;
    }

    public static Stack[] generarArray() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arrayBlock = new Stack[n];
        for (int i = 0; i < n; i++) {
            Stack a = new Stack();
            a.push(i);
            arrayBlock[i] = a;
        }
        return arrayBlock;
    }

    public static void moverBloques() {
        Scanner in = new Scanner(System.in);
        String opcion;
        do {
            opcion = in.nextLine();
            String n[] = opcion.split(" ");
            if (n[0].equals("move")) {
                if (n[2].equals("onto")) {
                    moveAontoB(Integer.parseInt(n[1]), Integer.parseInt(n[3]));
                } else {
                    moveAoverB(Integer.parseInt(n[1]), Integer.parseInt(n[3]));
                }
            } else if (n[0].equals("pile")) {
                if (n[2].equals("onto")) {
                    pileAontoB(Integer.parseInt(n[1]), Integer.parseInt(n[3]));
                } else {
                    pileAoverB(Integer.parseInt(n[1]), Integer.parseInt(n[3]));
                }
            }
        } while (!opcion.equals("quit"));
        quit();
    }

    private static void devolver(Stack pila, int lim) {
        while (pila.size() != 1) {
            int aux = (int) pila.peek();
            if (aux == lim) {
                break;
            }
            arrayBlock[aux].push(aux);
            pila.pop();
        }
    }

    public static void moveAontoB(int a, int b) {
        int posA = buscar(a);
        int posB = buscar(b);
        if (a != b && !arrayBlock[posB].contains(a) && !arrayBlock[posA].contains(b)) {
            devolver(arrayBlock[posA], a);
            devolver(arrayBlock[posB], b);
            arrayBlock[posB].push(arrayBlock[posA].pop());
        }
    }

    public static void moveAoverB(int a, int b) {
        int posA = buscar(a);
        int posB = buscar(b);
        if (a != b && !arrayBlock[posB].contains(a) && !arrayBlock[posA].contains(b)) {
            devolver(arrayBlock[posA], a);
            arrayBlock[posB].push(arrayBlock[posA].pop());
        }
    }

    public static void pileAontoB(int a, int b) {
        int posA = buscar(a);
        int posB = buscar(b);
        devolver(arrayBlock[posB], b);
        if (a != b && !arrayBlock[posB].contains(a) && !arrayBlock[posA].contains(b)) {
            Stack aux = new Stack();

            while (!arrayBlock[posA].isEmpty()) {
                int aux1 = (int) arrayBlock[posA].peek();
                if (aux1 == a) {
                    break;
                }
                aux.push(arrayBlock[posA].pop());
            }
            while (!aux.isEmpty()) {
                arrayBlock[posB].push(aux.pop());
            }
        }
    }

    public static void pileAoverB(int a, int b) {
        int posA = buscar(a);
        int posB = buscar(b);
        if (a != b && !arrayBlock[posB].contains(a) && !arrayBlock[posA].contains(b)) {
            Stack aux = new Stack();
            while (!arrayBlock[posA].isEmpty()) {
                int aux1 = (int) aux.push(arrayBlock[posA].pop());
       
                if (aux1 == a) {
                    break;
                }
            }
            while (!aux.isEmpty()) {
                arrayBlock[posB].push(aux.pop());
            }
        }
    }

    public static void quit() {
        for (int i = 0; i < arrayBlock.length; i++) {

            System.out.println(i + ": " + arrayBlock[i]);

        }
    }

    public static void main(String[] args) {
        generarArray();
        moverBloques();
    }

}
