/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

/**
 *
 * @author ljpalaciom
 */
public class Taller3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("La permutación: ");
        permutacion("abc");
        System.out.println("La combinatoria: ");
        combinatoria("abc");
        System.out.println("La torre de hanoi: ");
        Hannoi(3);
    }

    public static void combinatoria(String s) {
        combinatoria1("", s);
    }

    public static void combinatoria1(String base, String s) {
        if (s.length() == 0) {
            System.out.println(base);
        } else {
            combinatoria1(base + s.charAt(0), s.substring(1));
            combinatoria1(base, s.substring(1));
        }
    }

    public static void permutacion(String s) {
        permutacion1("", s);
    }

    private static void permutacion1(String base, String s) {
        if (s.isEmpty()) {
            System.out.println(base);
        } else {
            int cont = 0;
            while (cont < s.length()) {
                permutacion1(base + s.charAt(cont), s.replace(s.charAt(cont) + "", ""));
                cont++;
            }
        }
    }
    public static void Hannoi(int i) {
        Hannoi1(i, 1, 2, 3);
    }

    private static void Hannoi1(int i, int A, int B, int C) {
        if (i == 1) {
            System.out.println("mover ficha de " + A + " a " + C);
        } else {
            Hannoi1(i - 1, A, C, B);
            System.out.println("mover ficha de " + A + " a " + C);
            Hannoi1(i - 1, B, A, C);
        }
    }
}
