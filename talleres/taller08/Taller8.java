package taller8;

import java.util.*;

/**
 *
 * @author
 */
public class Taller8 {

    //Punto 1
    public static Stack<Integer> inversa(Stack<Integer> stack) {
        Queue<Integer> cola = new LinkedList<>();
        while (!stack.isEmpty()) {
            cola.add(stack.pop());
        }
        while (!cola.isEmpty()) {
            stack.push(cola.remove());
        }

        return stack;
    }

    //Punto 2
    public static void cola(Queue<String> queue) {
        while (!queue.isEmpty()) {
            System.out.println("Atendiendo a: " + queue.remove());
        }
    }

    //notacion polaca
    /**
     * Este metodo permite saber si el string es un operador aritmético básico
     * @param str
     * @return 
     */
    public static boolean isOperador(String str) {
        return str.startsWith("+")
                || str.startsWith("-")
                || str.startsWith("*")
                || str.startsWith("/");
    }

    /**
     * Este método permite obtener la operación aritmética entre dos factores
     * @param operador
     * @param factor1
     * @param factor2
     * @return 
     */
    public static int operar(String operador, int factor1, int factor2) {
        switch (operador) {
            case "+":
                return factor1 + factor2;
            case "-":
                return factor1 - factor2;
            case "*":
                return factor1 * factor2;
            default:
                return factor1 / factor2;
        }
    }

    public static int polaca(String string) {
        Stack<Integer> pila = new Stack<>();
        String partes[] = string.split(" ");

        for (int i = 0; i < partes.length; i++) {
            String actual = partes[i];
            if (!isOperador(actual)) {
                pila.push(Integer.parseInt(actual));
            } else {
                int factor2 = pila.pop();
                int factor1 = pila.pop();
                pila.push(operar(actual, factor1, factor2));  
            }
        }
      
        return pila.pop();
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Juan");
        queue.add("María");
        queue.add("Pedro");
        cola(queue);

        String s1 = "3 10 5 + *" ;
        System.out.println(polaca(s1));
    }
}
