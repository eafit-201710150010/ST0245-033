package laboratorio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EjercicioEnLinea {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = in.readLine()) != null) {
            LinkedList<Character> list = new LinkedList<>();
            boolean inicio = false;
            int index = 0;
            for (int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case '[':
                        inicio = true;
                        index = 0;
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
                        }
                        break;
                }
            }
            StringBuilder s = new StringBuilder();
            while (!list.isEmpty()) {
                s.append(list.remove());
            }
            System.out.println(s.toString());
        }
    }
}
