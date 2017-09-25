package laboratorio3;

import java.util.*;

public class EjercicioEnLinea {

    public static void linea() {
        LinkedList<Character> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una linea:");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        int index = list.indexOf('[');
        while (index != -1) {
            list.remove(index);
            
            int orden = 0;
            for (int i = index; i < list.size(); i++) {
                Character actual = list.get(i);
                list.remove(i);
                if (actual == ']') {
                    break;
                }              
                list.add(orden,actual);
                orden++;
            }
            index = list.indexOf('[');
        }
        str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        System.out.println(str);
    }
    

    public static void main(String[] args) {
        linea();
    }
}
