package laboratorio3;

import java.util.*;

public class EjercicioEnLinea {

    /**
     * Este metodo mejora la legilibilidad del codigo e imprime la respuesta en O(n)
     */
   
    public static void linea() {
        LinkedList<Character> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean inicio = false;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '[':
                    inicio = true;
                    break;
                case ']':
                    inicio = false;
                    index = 0;
                    break;
                default:
                    if (!inicio) {
                        list.add(str.charAt(i));
                    } else {
                        list.add(index++, str.charAt(i));
                    }   break;
            }
        }

        while (!list.isEmpty()) {
            System.out.print(list.remove());
        }

    }

    public static void main(String[] args) {
        System.out.println("Ingrese una linea");
        linea();
    }

}
