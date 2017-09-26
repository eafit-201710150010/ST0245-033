package laboratorio3;

import java.util.*;

public class EjercicioEnLinea {

    /**
     * Este metodo mejorado aprovecha el rapido acceso de un string y la rapida inserción de una lista enlazada
     */
    public static void linea() {
        LinkedList<Character> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una linea:");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                int j = 1;
                while (i + j < str.length()) {
                    if (str.charAt(j + i) == '[' || str.charAt(j + i) == ']') {
                        break;
                    } else if (str.charAt(j + i) != '[') {
                        list.add(j - 1, str.charAt(j + i));
                    }
                    j++;
                }
                i += j - 1;
            } else if (str.charAt(i) != ']') {
                list.add(str.charAt(i));
            }
        }
        String imprimir = "";
        while (!list.isEmpty()) {
            imprimir += list.remove();
        }
        System.out.println(imprimir);
    }

    public static void main(String[] args) {
        linea();
    }
}
